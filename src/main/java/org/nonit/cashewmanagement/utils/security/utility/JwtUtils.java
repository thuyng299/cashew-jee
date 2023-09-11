package org.nonit.cashewmanagement.utils.security.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.nonit.cashewmanagement.entity.EmployeeEntity;
import org.nonit.cashewmanagement.entity.RoleEnum;
import org.nonit.cashewmanagement.entity.StatusEnum;
import org.nonit.cashewmanagement.service.EmployeeService;
import org.nonit.cashewmanagement.utils.config.AppConfigService;
import org.nonit.cashewmanagement.utils.exception.AuthorizationException;
import org.nonit.cashewmanagement.utils.exception.ErrorMessage;
import org.nonit.cashewmanagement.utils.exception.InputValidationException;
import org.nonit.cashewmanagement.utils.security.rest.model.JwtRequest;
import org.nonit.cashewmanagement.utils.security.service.AuthenticationService;
import org.nonit.cashewmanagement.utils.security.service.dto.JwtResponse;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Stateless
public class JwtUtils {
    private static final String USERNAME = "USERNAME";
    private static final String ROLE = "ROLE";
    private static final String BEARER = "Bearer";
    private static final Validator validator =
            Validation.byDefaultProvider()
                    .configure()
                    .messageInterpolator(new ParameterMessageInterpolator())
                    .buildValidatorFactory()
                    .getValidator();

    @Inject
    private AuthenticationService authenticationService;

    @Inject
    private EmployeeService employeeService;

    public String generateToken(JwtRequest jwtRequest) throws AuthorizationException, InputValidationException {
        if (!authenticationService.checkAuthentication(jwtRequest)) {
            throw new InputValidationException(ErrorMessage.KEY_EMPLOYEE_USERNAME_PASSWORD_INVALID, ErrorMessage.EMPLOYEE_USERNAME_PASSWORD_INVALID);
        }
        String token;
        String secretKey = AppConfigService.getSecretKey();
        String issuer = AppConfigService.getIssuer();
        int liveTime = AppConfigService.getTimeToLive();
        RoleEnum roleEnum = employeeService.getEntityByUsername(jwtRequest.getUsername()).getRole();

        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            token = JWT.create()
                    .withIssuer(issuer)
                    .withIssuedAt(new Date())
                    .withJWTId(UUID.randomUUID().toString())
                    .withClaim(USERNAME, jwtRequest.getUsername())
                    .withClaim(ROLE, String.valueOf(roleEnum))
                    .withExpiresAt(new Date(System.currentTimeMillis() + liveTime))
                    .sign(algorithm);
        } catch (JWTCreationException | IllegalArgumentException e) {
            throw new AuthorizationException(Response.Status.UNAUTHORIZED, ErrorMessage.KEY_UNAUTHORIZED_ACCESS, ErrorMessage.UNAUTHORIZED_ACCESS);
        }
        return token;
    }

    public void validateJwtToken(String token) throws AuthorizationException {
        if (token == null) {
            throw new AuthorizationException(Response.Status.UNAUTHORIZED, ErrorMessage.KEY_UNAUTHORIZED_ACCESS, ErrorMessage.UNAUTHORIZED_ACCESS);
        }
        try {
            String secretKey = AppConfigService.getSecretKey();
            String issuer = AppConfigService.getIssuer();
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer).build();
            verifier.verify(token.substring(BEARER.length()).trim());
        } catch (JWTVerificationException | IllegalArgumentException e) {
            throw new AuthorizationException(Response.Status.UNAUTHORIZED, ErrorMessage.KEY_UNAUTHORIZED_ACCESS, ErrorMessage.UNAUTHORIZED_ACCESS);
        }
    }

    public JwtResponse generateJwtResponse(JwtRequest jwtRequest) throws AuthorizationException, InputValidationException {
        verifyJwtRequest(jwtRequest);
        String username = jwtRequest.getUsername().trim();
        String token = generateToken(jwtRequest);
        EmployeeEntity user = employeeService.getEntityByUsername(username);
        RoleEnum roleEnum = user.getRole();
        StatusEnum status = user.getStatus();

        return new JwtResponse(token, username, roleEnum, status);
    }

    public RoleEnum getRoleFromToken(String authorization) {
        String token = authorization.substring(BEARER.length()).trim();
        DecodedJWT decodedJWT = JWT.decode(token);
        return RoleEnum.valueOf(decodedJWT.getClaim(ROLE).asString());
    }

    public String getUsernameFromToken(String authorization) {
        String token = authorization.substring(BEARER.length()).trim();
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim(USERNAME).asString();
    }

    public Date getExpireTokenTime(String authorization) {
        String token = authorization.substring(BEARER.length()).trim();
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getExpiresAt();
    }

    private boolean isActive(StatusEnum status) {
        return status.equals(StatusEnum.ACTIVE);
    }

    public void verifyJwtRequest(JwtRequest jwtRequest) throws AuthorizationException, InputValidationException {
        Set<ConstraintViolation<JwtRequest>> violations = validator.validate(jwtRequest);

        if (CollectionUtils.isNotEmpty(violations)) {
            throw new ConstraintViolationException(violations);
        }

        StatusEnum statusEnum = employeeService.getEntityByUsername(jwtRequest.getUsername()).getStatus();
        if (!isActive(statusEnum)) {
            throw new AuthorizationException(Response.Status.FORBIDDEN, ErrorMessage.KEY_FORBIDDEN_ACCESS, ErrorMessage.FORBIDDEN_ACCESS);
        }
    }
}

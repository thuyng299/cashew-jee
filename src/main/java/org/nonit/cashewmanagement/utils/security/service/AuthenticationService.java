package org.nonit.cashewmanagement.utils.security.service;

import org.nonit.cashewmanagement.entity.EmployeeEntity;
import org.nonit.cashewmanagement.utils.exception.ErrorMessage;
import org.nonit.cashewmanagement.utils.exception.InputValidationException;
import org.nonit.cashewmanagement.utils.security.rest.model.JwtRequest;
import org.nonit.cashewmanagement.service.EmployeeService;
import org.mindrot.jbcrypt.BCrypt;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Base64;

@Stateless
public class AuthenticationService {

    @Inject
    private EmployeeService employeeService;

    public boolean checkAuthentication(JwtRequest jwtRequest) throws InputValidationException {
        EmployeeEntity employee = employeeService.getEntityByUsername(jwtRequest.getUsername());
        String password = decryptBase64Password(jwtRequest.getPassword());
        return BCrypt.checkpw(password, employee.getPassword());
    }

    private String decryptBase64Password(String password) throws InputValidationException {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(password);
            return new String(decodedBytes);
        } catch (IllegalArgumentException e) {
            throw new InputValidationException(ErrorMessage.KEY_EMPLOYEE_USERNAME_PASSWORD_INVALID, ErrorMessage.EMPLOYEE_USERNAME_PASSWORD_INVALID);
        }
    }

}

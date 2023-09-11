package org.nonit.cashewmanagement.utils.security.rest;

import org.nonit.cashewmanagement.service.EmployeeService;
import org.nonit.cashewmanagement.utils.exception.AuthorizationException;
import org.nonit.cashewmanagement.utils.exception.InputValidationException;
import org.nonit.cashewmanagement.utils.security.rest.model.JwtRequest;
import org.nonit.cashewmanagement.utils.security.service.AuthenticationService;
import org.nonit.cashewmanagement.utils.security.service.dto.JwtResponse;
import org.nonit.cashewmanagement.utils.security.utility.JwtUtils;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
public class AuthResource {

    @Inject
    private JwtUtils jwtUtils;

    @Inject
    private AuthenticationService authenticationService;

    @Inject
    private EmployeeService employeeService;

    @POST
    @Path("/login")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getJwtResponse(JwtRequest jwtRequest) throws AuthorizationException, InputValidationException {
        JwtResponse jwtResponse = jwtUtils.generateJwtResponse(jwtRequest);
        return Response.ok(jwtResponse).build();
    }
}

package org.nonit.utils.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {

    @Override
    public Response toResponse(ResourceNotFoundException e) {
        ResponseBody responseBody = e.getResponseBody();
        return Response.status(responseBody.getStatusCode())
                .entity(responseBody)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

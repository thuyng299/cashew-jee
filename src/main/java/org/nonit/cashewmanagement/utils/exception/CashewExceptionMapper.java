package org.nonit.cashewmanagement.utils.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CashewExceptionMapper implements ExceptionMapper<CashewException> {
    private static final Logger logger = LogManager.getLogger(CashewExceptionMapper.class);

    @Override
    public Response toResponse(CashewException e) {
        StackTraceElement[] stackTraceArray = e.getStackTrace();
        for (StackTraceElement s : stackTraceArray) {
            logger.error(s.getClassName());
        }

        ResponseBody responseBody = e.getResponseBody();

        return Response.status(responseBody.getStatusCode())
                .entity(responseBody)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

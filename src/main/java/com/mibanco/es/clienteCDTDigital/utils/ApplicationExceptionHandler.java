package com.mibanco.es.clienteCDTDigital.utils;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class ApplicationExceptionHandler implements ExceptionMapper<ApplicationException> {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    @Override
    public Response toResponse(ApplicationException e) {
        LOG.error(e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}

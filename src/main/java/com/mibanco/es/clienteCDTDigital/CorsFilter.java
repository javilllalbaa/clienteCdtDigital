package com.mibanco.es.clienteCDTDigital;

import jakarta.ws.rs.ext.Provider;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.Response;

@Provider
public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        requestContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        requestContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        requestContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        requestContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        if (requestContext.getHeaderString("Origin") != null) {
            responseContext.getHeaders().add("Access-Control-Allow-Origin", requestContext.getHeaderString("Origin"));
        }
        if (requestContext.getMethod().equals("OPTIONS")) {
            responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
            responseContext.setStatus(Response.Status.OK.getStatusCode());
        }
    }
}

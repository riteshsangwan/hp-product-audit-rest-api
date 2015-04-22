package com.assignments.contactsapp.filters;


import com.assignments.contactsapp.core.ApiResponse;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Copyright 2015
 * Created by anurag on 22/4/15 06:33 AM.
 *
 * @author              anurag
 * @version             1.0
 */
@Provider
public class ResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        Object entity = containerResponseContext.getEntity();
        if(entity != null && entity instanceof ApiResponse) {
            ApiResponse response = (ApiResponse) entity;
            containerResponseContext.setEntity(response.getPayload());
            containerResponseContext.setStatus(response.getStatus().getStatusCode());
        }
        MultivaluedMap<String, Object> headers = containerResponseContext.getHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        headers.add("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS, HEAD");
    }
}
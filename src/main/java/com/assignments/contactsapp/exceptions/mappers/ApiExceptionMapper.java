package com.assignments.contactsapp.exceptions.mappers;

import com.assignments.contactsapp.exceptions.ApiException;
import com.assignments.contactsapp.exceptions.ErrorCodes;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Copyright 2015
 * Created by anurag on 19/4/15:11:08 AM.
 *
 * @author              anurag
 * @version             1.0
 */
@Provider
public class ApiExceptionMapper implements ExceptionMapper<ApiException> {

    @Override
    public Response toResponse(ApiException apiException) {
        // perform logging here and return status
        if(apiException.getCause() != null) {
            apiException.getCause().printStackTrace();
        }
        if(apiException.getErrors() != null) {
            return Response.status(apiException.getStatus()).entity(apiException.getErrors()).build();
        } else {
            return Response.status(apiException.getStatus() != null ? apiException.getStatus() : Response.Status.INTERNAL_SERVER_ERROR).entity(ErrorCodes.INTERNAL_SERVER_ERROR).build();
        }
    }
}

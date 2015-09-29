/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.exceptions.mappers;

import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import com.hp.inventory.audit.rest.service.exceptions.EntityNotFoundException;
import io.dropwizard.jersey.errors.LoggingExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Map the exceptions to HTTP STATUS CODES
 *
 * @author              TCSCODER
 * @version             1.0
 */
@Provider
public class RestExceptionMapper extends LoggingExceptionMapper<RuntimeException> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionMapper.class);

    /**
     * Map the Exception to HTTP STATUS CODE
     * @param throwable the throwable to map
     * @return Response instance
     */
    @Override
    public Response toResponse(RuntimeException throwable) {
        // perform logging here and return status
        LOGGER.error("Exception while processing request", throwable);
        Error error = new Error();
        if(throwable instanceof IllegalArgumentException) {
            error.setMessage(throwable.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        } else if(throwable instanceof EntityNotFoundException) {
            error.setMessage(throwable.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        } else if(throwable instanceof ApiException) {
            error.setMessage("Error occur while processing the request, Internal Error Message [" + throwable.getMessage() + "]");
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        } else if(throwable instanceof NotFoundException) {
            error.setMessage("The requested resource is not found on this server");
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        } else {
            error.setMessage("Error occur while processing the request");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
        }
    }

    /**
     * Helper class to map a exception message to a json entity
     */
    class Error {
        /**
         * Error messsage
         */
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

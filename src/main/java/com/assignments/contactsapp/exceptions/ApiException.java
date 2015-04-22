package com.assignments.contactsapp.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2015
 * Created by anurag on 21/4/15 11:04 AM.
 *
 * @author          anurag
 * @version         1.0
 */
public class ApiException extends WebApplicationException {

    private List<ErrorCodes> errors;
    private Response.Status status;

    public ApiException(Response.Status status, List<ErrorCodes> errors, Throwable cause) {
        super(cause);
        this.status = status;
        this.errors = errors;
    }
    public ApiException(Response.Status status, Throwable cause) {
        super(cause);
        this.status = status;
    }

    public List<ErrorCodes> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorCodes> errors) {
        this.errors = errors;
    }

    public Response.Status getStatus() {
        return status;
    }

    public void setStatus(Response.Status status) {
        this.status = status;
    }

    public ApiException addError(ErrorCodes error) {
        if(this.getErrors() == null) {
            this.setErrors(new ArrayList<ErrorCodes>());
        }
        this.getErrors().add(error);
        return this;
    }
}

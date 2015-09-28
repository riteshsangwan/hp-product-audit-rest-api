/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.exceptions;

import javax.ws.rs.WebApplicationException;

/**
 * Custom ApiException class.
 *
 * @author          TCSCODER
 * @version         1.0
 */
public class ApiException extends WebApplicationException {

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}

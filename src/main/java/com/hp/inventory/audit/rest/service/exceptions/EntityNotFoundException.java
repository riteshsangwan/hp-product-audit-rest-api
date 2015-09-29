/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.exceptions;

/**
 * Represents that an entity is not found on this server
 *
 * @author TCSCODER
 * @version 1.0
 */
public class EntityNotFoundException extends ApiException {

    /**
     * {@inheritDoc}
     */
    public EntityNotFoundException(String message) {
        super(message);
    }

    /**
     * {@inheritDoc}
     */
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

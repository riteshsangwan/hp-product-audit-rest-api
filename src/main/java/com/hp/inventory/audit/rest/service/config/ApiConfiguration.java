/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.config;

import javax.inject.Singleton;

/**
 * Represents API configuration for the application
 *
 * @author              TCSCODER
 * @version             1.0
 */
@Singleton
public class ApiConfiguration {

    public static final String NAMED_BINDING = "com.hp.product.inventory.rest.service.config";

    /**
     * Represents the default limit of number of entities to return in single API call
     */
    private int defaultLimit;

    /**
     * Gets the defaultLimit
     * @return the defaultLimit
     */
    public int getDefaultLimit() {
        return defaultLimit;
    }

    /**
     * Sets the defaultLimit
     * @param defaultLimit the defaultLimit value to set
     */
    public void setDefaultLimit(int defaultLimit) {
        this.defaultLimit = defaultLimit;
    }
}

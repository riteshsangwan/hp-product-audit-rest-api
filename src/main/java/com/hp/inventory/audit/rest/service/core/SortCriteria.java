/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

/**
 * Represents a sort criteria
 * A sort criteria will be a key and a sort order
 *
 * @author TCSCODER
 * @version 1.0
 */
public class SortCriteria {
    /**
     * Represents the key(column) to sort
     */
    private String key;
    /**
     * Represents the sort order
     */
    private SortOrder order;

    /**
     * Gets the key
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the key
     * @param key the value to set to key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Gets the order
     * @return the order
     */
    public SortOrder getOrder() {
        return order;
    }

    /**
     * Sets the order
     * @param order the value to set to order
     */
    public void setOrder(SortOrder order) {
        this.order = order;
    }
}

/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

/**
 * API's Search Criteria's which support pagination should extend this class
 *
 * @author TCSCODER
 * @version 1.0
 */
public class Pagination extends Sorting {

    /**
     * Represents the maximum number of entities return in single API call
     */
    private Integer limit;
    /**
     * Represents the offset
     */
    private Integer offset;

    /**
     * Gets the limit
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets the limit
     * @param limit the value to set to limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Gets the limit
     * @return the limit
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Sets the offset
     * @param offset the value to set to offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}

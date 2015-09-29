/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import org.apache.commons.lang3.StringUtils;

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
    public void setLimit(String limit) {
        if(StringUtils.isNotBlank(limit)) {
            try {
                this.limit = Integer.parseInt(limit);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException(limit + " value is invalid. Limit can only be an integer value");
            }
        }
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
    public void setOffset(String offset) {
        if(StringUtils.isNotBlank(offset)) {
            try {
                this.offset = Integer.parseInt(offset);
                if(this.offset < 0) {
                    throw new IllegalArgumentException("Offset should be greater than 0");
                }
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException(offset + " value is invalid. Offset can only be an integer value");
            }
        }
    }
}

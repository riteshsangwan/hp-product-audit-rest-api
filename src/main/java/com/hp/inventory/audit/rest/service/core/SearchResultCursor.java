/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Represents the search result cursor for list API calls
 *
 * @author TCSCODER
 * @version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchResultCursor {

    /**
     * Represents the limit
     */
    private int limit;
    /**
     * Represents the offset
     */
    private int offset;
    /**
     * Represents the total number of records
     */
    private long totalCount;
    /**
     * Represents the total pages
     */
    private long totalPages;


    /**
     * Gets the limit
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the limit
     * @param limit the value to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Gets the offset
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Sets the offset
     * @param offset the value to set
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Gets the total count
     * @return the total count
     */
    public long getTotalCount() {
        return totalCount;
    }

    /**
     * Sets the total count
     * @param totalCount the value to set
     */
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Gets the total pages
     * @return the total pages
     */
    public long getTotalPages() {
        return totalPages;
    }

    /**
     * Sets the total pages
     * @param totalPages the value to set
     */
    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}

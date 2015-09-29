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
    private Integer limit;
    /**
     * Represents the offset
     */
    private Integer offset;
    /**
     * Represents the total number of records
     */
    private Long totalCount;
    /**
     * Represents the total pages
     */
    private Long totalPages;


    /**
     * Gets the limit
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets the limit
     * @param limit the value to set
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Gets the offset
     * @return the offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Sets the offset
     * @param offset the value to set
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * Gets the total count
     * @return the total count
     */
    public Long getTotalCount() {
        return totalCount;
    }

    /**
     * Sets the total count
     * @param totalCount the value to set
     */
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Gets the total pages
     * @return the total pages
     */
    public Long getTotalPages() {
        return totalPages;
    }

    /**
     * Sets the total pages
     * @param totalPages the value to set
     */
    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }
}

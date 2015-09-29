/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import java.io.Serializable;
import java.util.List;

/**
 * Represents service result
 * Instances of this class are returned by the Service methods
 *
 * @author TCSCODER
 * @version 1.0
 */
public class ServiceResult<M extends Serializable> {
    /**
     * Represents a list of objects of type M
     * This will be returned by list operation
     */
    private List<M> results;
    /**
     * Represents a object of type M
     * This will be returned by get operation
     */
    private M result;
    /**
     * Represents the search result cursor
     */
    private SearchResultCursor cursor;

    /**
     * Instantiate with a list result object
     * @param results the result objects to instantiate with
     */
    public ServiceResult(List<M> results, SearchResultCursor cursor) {
        this.results = results;
        this.cursor = cursor;
    }

    /**
     * Instantiate with a single result object
     * @param result the result object to instantiate with
     */
    public ServiceResult(M result) {
        this.result = result;
    }

    /**
     * Gets the results
     * @return the results
     */
    public List<M> getResults() {
        return this.results;
    }

    /**
     * Gets the result
     * @return the result
     */
    public M getResult() {
        return this.result;
    }

    /**
     * Gets the cursor
     * @return the cursor
     */
    public SearchResultCursor getCursor() {
        return this.cursor;
    }
}

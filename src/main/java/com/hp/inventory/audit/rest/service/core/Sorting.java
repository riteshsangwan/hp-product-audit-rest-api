/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import java.util.List;

/**
 * API's search criteria which supports sorting should extend this class
 *
 * @author TCSCODER
 * @version 1.0
 */
public class Sorting {

    /**
     * Represents the sort
     * This property is a multi-valued property
     */
    private List<SortCriteria> sort;

    /**
     * Gets the sort
     * @return the sort
     */
    public List<SortCriteria> getSort() {
        return sort;
    }

    /**
     * Sets the sort
     * @param sort the value to set to sort
     */
    public void setSort(List<SortCriteria> sort) {
        this.sort = sort;
    }
}

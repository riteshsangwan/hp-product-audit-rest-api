/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * API's Search criteria which support partial response should extend this class
 *
 * @author TCSCODER
 * @version 1.0
 */
public class PartialResponse extends Pagination {

    /**
     * Represents the fields
     */
    private List<String> fields;

    /**
     * Gets the fields
     * @return the fields
     */
    public List<String> getFields() {
        return fields;
    }

    /**
     * Sets the fields
     * @param fields the value to set to fields
     */
    public void setFields(String fields) {
        if(StringUtils.isNotBlank(fields)) {
            this.fields = Arrays.asList(fields.split(","));
        }
    }
}

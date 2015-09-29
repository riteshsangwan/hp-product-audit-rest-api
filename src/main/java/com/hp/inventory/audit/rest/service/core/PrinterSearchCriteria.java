/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents the search criteria for /printers API's
 *
 * @author TCSCODER
 * @version 1.0
 */
public class PrinterSearchCriteria extends SearchCriteria {

    /**
     * Represents the printer type
     */
    private String type;

    /**
     * Gets the type
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type
     * @param type the value to set to type
     */
    public void setType(String type) {
        if(StringUtils.isNotBlank(type)) {
            this.type = type;
        }
    }
}

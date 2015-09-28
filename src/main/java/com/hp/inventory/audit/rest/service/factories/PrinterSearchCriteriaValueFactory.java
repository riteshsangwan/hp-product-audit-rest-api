/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.factories;

import com.hp.inventory.audit.rest.service.core.PrinterSearchCriteria;
import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Factory implementation for PrinterSearchCriteria
 * This should return an instance of PrinterSearchCriteria which will be injected into resource methods
 *
 * @author TCSCODER
 * @version 1.0
 */
public class PrinterSearchCriteriaValueFactory extends AbstractContainerRequestValueFactory<PrinterSearchCriteria> {

    @Inject
    private HttpServletRequest request;

    @Override
    public PrinterSearchCriteria provide() throws ApiException {
        PrinterSearchCriteria criteria = new PrinterSearchCriteria();
        return criteria;
    }
}
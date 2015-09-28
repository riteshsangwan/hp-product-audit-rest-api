/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.factories;

import com.hp.inventory.audit.rest.service.core.SearchCriteria;
import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Factory implementation for SearchCriteria
 * This should return an instance of SearchCriteria which will be injected into resource methods
 *
 * @author TCSCODER
 * @version 1.0
 */
public class SearchCriteriaValueFactory extends AbstractContainerRequestValueFactory<SearchCriteria> {

    @Inject
    private HttpServletRequest request;

    @Override
    public SearchCriteria provide() throws ApiException {
        SearchCriteria criteria = new SearchCriteria();
        return criteria;
    }
}
/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.factories;

import com.hp.inventory.audit.rest.service.core.SearchCriteria;
import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import com.hp.inventory.audit.rest.service.util.Utilities;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

/**
 * Factory implementation for SearchCriteria
 * This should return an instance of SearchCriteria which will be injected into resource methods
 *
 * @author TCSCODER
 * @version 1.0
 */
public class SearchCriteriaValueFactory extends AbstractContainerRequestValueFactory<SearchCriteria> {

    /**
     * Inject the http servlet request
     */
    @Inject
    private HttpServletRequest request;
    /**
     * Inject Jersey context param UriInfo
     */
    @Inject
    @Context
    private UriInfo info;

    /**
     * Get an handle of utilities class to parse query strings
     */
    @Inject
    private Utilities utilities;

    @Override
    public SearchCriteria provide() throws ApiException {
        MultivaluedMap<String, String> queryParams = info.getQueryParameters();
        return utilities.parseSearchCriteria(queryParams, false);
    }
}
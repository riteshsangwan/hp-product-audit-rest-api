/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.util;

import com.google.inject.Singleton;
import com.hp.inventory.audit.rest.service.config.ApiConfiguration;
import com.hp.inventory.audit.rest.service.core.SearchCriteria;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Utilities class to parse the query parameters
 * This class cannot be extended
 *
 * @author TCSCODER
 * @version 1.0
 */
@Singleton
public final class Utilities {

    private final ApiConfiguration apiConfiguration;

    @Inject
    public Utilities(@Named(ApiConfiguration.NAMED_BINDING) ApiConfiguration apiConfiguration) {
        this.apiConfiguration = apiConfiguration;
    }

    public SearchCriteria parseSearchCriteria(MultivaluedMap<String, String> queryParams) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setMaxCurrentPrice(queryParams.getFirst("maxCurrentPrice"));
        criteria.setMinCurrentPrice(queryParams.getFirst("minCurrentPrice"));
        criteria.setRating(queryParams.getFirst("rating"));
        criteria.setMinParseDate(queryParams.getFirst("minParseDate"));
        criteria.setMaxParseDate(queryParams.getFirst("maxParseDate"));
        criteria.setImages(queryParams.getFirst("images"));
        criteria.setRa(queryParams.getFirst("ra"));
        criteria.setFields(queryParams.getFirst("fields"));
        criteria.setLimit(queryParams.getFirst("limit"));
        criteria.setOffset(queryParams.getFirst("offset"));
        criteria.setSort(queryParams.getFirst("sort"));
        return criteria;
    }
}

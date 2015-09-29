/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.util;

import com.google.inject.Singleton;
import com.hp.inventory.audit.rest.service.core.PrinterSearchCriteria;
import com.hp.inventory.audit.rest.service.core.ProductSearchCriteria;
import com.hp.inventory.audit.rest.service.core.SearchCriteria;

import javax.ws.rs.core.MultivaluedMap;
import java.lang.reflect.InvocationTargetException;

/**
 * Utilities class to parse the query parameters
 * This class cannot be extended
 *
 * @author TCSCODER
 * @version 1.0
 */
@Singleton
public final class Utilities {

    /**
     * Map a map of query params into an instance of SearchCriteria
     *
     * @param queryParams
     * @return an instance of SearchCriteria
     */
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

    /**
     * Map a map of query params into an instance of PrinterSearchCriteria
     *
     * @param queryParams
     * @return an instance of PrinterSearchCriteria
     */
    public PrinterSearchCriteria parsePrinterSearchCriteria(MultivaluedMap<String, String> queryParams) throws InvocationTargetException, IllegalAccessException {
        PrinterSearchCriteria criteria = new PrinterSearchCriteria();
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
        criteria.setType(queryParams.getFirst("type"));
        return criteria;
    }

    /**
     * Map a map of query params into an instance of ProductSearchCriteria
     *
     * @param queryParams
     * @return an instance of ProductSearchCriteria
     */
    public ProductSearchCriteria parseProductSearchCriteria(MultivaluedMap<String, String> queryParams) throws InvocationTargetException, IllegalAccessException {
        ProductSearchCriteria criteria = new ProductSearchCriteria();
        criteria.setMaxCurrentPrice(queryParams.getFirst("maxCurrentPrice"));
        criteria.setMinCurrentPrice(queryParams.getFirst("minCurrentPrice"));
        criteria.setRating(queryParams.getFirst("rating"));
        criteria.setImages(queryParams.getFirst("images"));
        criteria.setRa(queryParams.getFirst("ra"));
        criteria.setFields(queryParams.getFirst("fields"));
        criteria.setLimit(queryParams.getFirst("limit"));
        criteria.setOffset(queryParams.getFirst("offset"));
        criteria.setSort(queryParams.getFirst("sort"));

        criteria.setProductType(queryParams.getFirst("productType"));

        criteria.setMinAuditTimeStamp(queryParams.getFirst("minAuditTimeStamp"));
        criteria.setMaxAuditTimeStamp(queryParams.getFirst("maxAuditTimeStamp"));

        criteria.setMinDateAdded(queryParams.getFirst("minDateAdded"));
        criteria.setMaxDateAdded(queryParams.getFirst("maxDateAdded"));

        criteria.setPreviousPrice(queryParams.getFirst("previousPrice"));

        criteria.setMinDateOfPriceChange(queryParams.getFirst("minDateOfPriceChange"));
        criteria.setMaxDateOfPriceChange(queryParams.getFirst("maxDateOfPriceChange"));

        criteria.setPreviousRating(queryParams.getFirst("previousRating"));

        criteria.setMinDateOfRatingChange(queryParams.getFirst("minDateOfRatingChange"));
        criteria.setMaxDateOfRatingChange(queryParams.getFirst("maxDateOfRatingChange"));

        criteria.setMinDateOfParsingError(queryParams.getFirst("minDateOfParsingError"));
        criteria.setMaxDateOfParsingError(queryParams.getFirst("maxDateOfParsingError"));

        criteria.setMinComingSoonDate(queryParams.getFirst("minComingSoonDate"));
        criteria.setMaxComingSoonDate(queryParams.getFirst("maxComingSoonDate"));

        criteria.setMinAvailableForSaleDate(queryParams.getFirst("minAvailableForSaleDate"));
        criteria.setMaxAvailableForSaleDate(queryParams.getFirst("maxAvailableForSaleDate"));

        return criteria;
    }
}

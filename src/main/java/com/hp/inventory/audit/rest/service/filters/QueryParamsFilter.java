/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.filters;

import com.hp.inventory.audit.rest.service.annotations.QueryParams;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Filter class to validate the query params of a request
 *
 * @author TCSCODER
 * @version 1.0
 */
@Provider
@QueryParams
public class QueryParamsFilter implements ContainerRequestFilter {

    private final ResourceInfo resourceInfo;

    @Inject
    public QueryParamsFilter(ResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        MultivaluedMap<String, String> queryParams = requestContext.getUriInfo().getQueryParameters();
        String fieldsParam = queryParams.getFirst("fields");
        String sortParam = queryParams.getFirst("sort");
        // if the fields is not null/empty
        // if the fields is null/empty then by default return all fields
        if(StringUtils.isNotBlank(fieldsParam)) {
            List<String> availableFields = Arrays.asList(fieldsParam.split(","));
            List<String> validFields = getDefinedFields();
            // validate the fields
            for(String field: availableFields) {
                if(validFields.indexOf(field) == -1) {
                    throw new IllegalArgumentException(field + " is not a valid fields value");
                }
            }
        }
        if(StringUtils.isNotBlank(sortParam)) {
            List<String> availableSortColumns = Arrays.asList(sortParam.split(","));
            List<String> validSortColumns = getDefinedSortColumns();
            for(String sortColumn: availableSortColumns) {
                String sortValue = sortColumn.substring(1);
                if(!sortColumn.startsWith("+") && !sortColumn.startsWith("-")) {
                    throw new IllegalArgumentException("Sort Order can only be '+' or '-'. For eg: To sort by productNumber ascending use +productNumber");
                } else if(validSortColumns.indexOf(sortValue) == -1) {
                    throw new IllegalArgumentException(sortValue + " is not a valid sort criteria");
                }
            }
        }
    }

    /**
     * Private helper method to extract the valid field values from the ResourceInfo
     * @return a list of field values
     */
    private List<String> getDefinedFields() {
        QueryParams queryParams = resourceInfo.getResourceMethod().getAnnotation(QueryParams.class);
        return Arrays.asList(queryParams.fields());
    }

    /**
     * Private helper method to extract the valid sort coulmns values from the ResourceInfo
     * @return a list of field values
     */
    private List<String> getDefinedSortColumns() {
        QueryParams queryParams = resourceInfo.getResourceMethod().getAnnotation(QueryParams.class);
        return Arrays.asList(queryParams.sortColumns());
    }
}

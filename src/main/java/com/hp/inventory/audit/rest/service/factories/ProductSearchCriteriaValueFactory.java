/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.factories;

import com.hp.inventory.audit.rest.service.core.ProductSearchCriteria;
import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Factory implementation for ProductSearchCriteria
 * This should return an instance of ProductSearchCriteria which will be injected into resource methods
 *
 * @author TCSCODER
 * @version 1.0
 */
public class ProductSearchCriteriaValueFactory extends AbstractContainerRequestValueFactory<ProductSearchCriteria> {

    @Inject
    private HttpServletRequest request;

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductSearchCriteria provide() throws ApiException {
        ProductSearchCriteria criteria = new ProductSearchCriteria();
        return criteria;
    }
}
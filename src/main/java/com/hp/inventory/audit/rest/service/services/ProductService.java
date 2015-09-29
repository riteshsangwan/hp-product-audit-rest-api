/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hp.inventory.audit.rest.service.Configuration;
import com.hp.inventory.audit.rest.service.config.ApiConfiguration;
import com.hp.inventory.audit.rest.service.dao.ProductDAO;
import io.dropwizard.validation.Validated;

import javax.inject.Named;

/**
 * Provides a contract between ProductDAO and '/products' endpoints
 * @author              TCSCODER
 * @version             1.0
 */
@Singleton
public class ProductService {

    private final ProductDAO productDAO;
    private final Configuration configuration;
    private final ApiConfiguration apiConfiguration;

    /**
     * Default constructor. Whenever an instance of this class is created 'juice' will make sure that all the dependencies are properly injected
     * @param   productDAO                              DAO implementation for this service
     * @param   configuration                           Application configuration instance
     * @param   apiConfiguration                        commons api configuration instance
     */
    @Inject
    public ProductService(ProductDAO productDAO, @Validated Configuration configuration, @Validated @Named(ApiConfiguration.NAMED_BINDING) ApiConfiguration apiConfiguration) {
        this.productDAO = productDAO;
        this.apiConfiguration = apiConfiguration;
        this.configuration = configuration;
    }
}

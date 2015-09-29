/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.services;

import com.google.inject.Inject;
import com.hp.inventory.audit.rest.service.config.ApiConfiguration;
import com.hp.inventory.audit.rest.service.core.SearchCriteria;
import com.hp.inventory.audit.rest.service.core.ServiceResult;
import com.hp.inventory.audit.rest.service.core.Laptop;
import com.hp.inventory.audit.rest.service.dao.LaptopDAO;
import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import com.hp.inventory.audit.rest.service.exceptions.EntityNotFoundException;
import io.dropwizard.validation.Validated;

import javax.inject.Named;

/**
 * Provides a contract between LaptopDAO and '/laptops' endpoints
 *
 * @author TCSCODER
 * @version 1.0
 */
public class LaptopService {

    private final LaptopDAO laptopDAO;
    private final ApiConfiguration apiConfiguration;

    /**
     * Default constructor. Whenever an instance of this class is created 'juice' will make sure that all the dependencies are properly injected
     * @param   laptopDAO                               DAO implementation for this service
     * @param   apiConfiguration                        commons api configuration instance
     */
    @Inject
    public LaptopService(LaptopDAO laptopDAO, @Validated @Named(ApiConfiguration.NAMED_BINDING) ApiConfiguration apiConfiguration) {
        this.laptopDAO = laptopDAO;
        this.apiConfiguration = apiConfiguration;
    }

    public ServiceResult<Laptop> getLaptops(SearchCriteria criteria) throws ApiException {
        // set default limit
        if(criteria.getLimit() == null) {
            criteria.setLimit(apiConfiguration.getDefaultLimit());
        }
        return laptopDAO.search(criteria);
    }

    /**
     * Return a laptop based on the given product number
     *
     * @param productNumber the productNumber
     * @return Laptop instnace based on the given productNumber
     * @throws ApiException if any exception occurs
     * @throws EntityNotFoundException if the laptop is not found with given product number
     */
    public ServiceResult<Laptop> getLaptop(String productNumber) throws ApiException, EntityNotFoundException {
        Laptop laptop = laptopDAO.findById(productNumber);
        if(laptop == null) {
            throw new EntityNotFoundException("Laptop not found with the given product number");
        }
        return new ServiceResult<Laptop>(laptop);
    }
}

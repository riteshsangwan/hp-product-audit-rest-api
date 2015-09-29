/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.services;

import com.google.inject.Inject;
import com.hp.inventory.audit.rest.service.config.ApiConfiguration;
import com.hp.inventory.audit.rest.service.core.Desktop;
import com.hp.inventory.audit.rest.service.core.SearchCriteria;
import com.hp.inventory.audit.rest.service.core.ServiceResult;
import com.hp.inventory.audit.rest.service.dao.DesktopDAO;
import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import com.hp.inventory.audit.rest.service.exceptions.EntityNotFoundException;
import io.dropwizard.validation.Validated;

import javax.inject.Named;

/**
 * Provides a contract between DesktopDAO and '/desktops' endpoints
 *
 * @author TCSCODER
 * @version 1.0
 */
public class DesktopService {

    private final DesktopDAO desktopDAO;
    private final ApiConfiguration apiConfiguration;

    /**
     * Default constructor. Whenever an instance of this class is created 'juice' will make sure that all the dependencies are properly injected
     * @param   desktopDAO                              DAO implementation for this service
     * @param   apiConfiguration                        commons api configuration instance
     */
    @Inject
    public DesktopService(DesktopDAO desktopDAO, @Validated @Named(ApiConfiguration.NAMED_BINDING) ApiConfiguration apiConfiguration) {
        this.desktopDAO = desktopDAO;
        this.apiConfiguration = apiConfiguration;
    }

    public ServiceResult<Desktop> getDesktops(SearchCriteria criteria) throws ApiException {
        // set default limit
        if(criteria.getLimit() == null) {
            criteria.setLimit(apiConfiguration.getDefaultLimit());
        }
        return desktopDAO.search(criteria);
    }

    /**
     * Return a desktop based on the given product number
     *
     * @param productNumber the productNumber
     * @return Desktop instnace based on the given productNumber
     * @throws ApiException if any exception occurs
     * @throws EntityNotFoundException if the desktop is not found with given product number
     */
    public ServiceResult<Desktop> getDesktop(String productNumber) throws ApiException, EntityNotFoundException {
        Desktop desktop = desktopDAO.findById(productNumber);
        if(desktop == null) {
            throw new EntityNotFoundException("Desktop not found with the given product number");
        }
        return new ServiceResult<Desktop>(desktop);
    }
}

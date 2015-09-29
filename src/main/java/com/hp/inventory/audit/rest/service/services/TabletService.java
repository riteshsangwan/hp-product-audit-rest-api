/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.services;

import com.google.inject.Inject;
import com.hp.inventory.audit.rest.service.config.ApiConfiguration;
import com.hp.inventory.audit.rest.service.core.SearchCriteria;
import com.hp.inventory.audit.rest.service.core.ServiceResult;
import com.hp.inventory.audit.rest.service.core.Tablet;
import com.hp.inventory.audit.rest.service.dao.TabletDAO;
import com.hp.inventory.audit.rest.service.exceptions.EntityNotFoundException;
import io.dropwizard.validation.Validated;

import javax.inject.Named;

/**
 * Provides a contract between TabletDAO and '/tablets' endpoints
 *
 * @author TCSCODER
 * @version 1.0
 */
public class TabletService {

    private final TabletDAO tabletDAO;
    private final ApiConfiguration apiConfiguration;

    /**
     * Default constructor. Whenever an instance of this class is created 'juice' will make sure that all the dependencies are properly injected
     * @param   tabletDAO                               DAO implementation for this service
     * @param   apiConfiguration                        commons api configuration instance
     */
    @Inject
    public TabletService(TabletDAO tabletDAO, @Validated @Named(ApiConfiguration.NAMED_BINDING) ApiConfiguration apiConfiguration) {
        this.tabletDAO = tabletDAO;
        this.apiConfiguration = apiConfiguration;
    }

    /**
     * Search the tablets based on the search criteria
     * @param criteria the search criteria
     * @return Generic ServiceResult with embedded search results and search result cursor
     */
    public ServiceResult<Tablet> getTablets(SearchCriteria criteria) {
        // set default limit
        if(criteria.getLimit() == null) {
            criteria.setLimit(apiConfiguration.getDefaultLimit());
        }
        return tabletDAO.search(criteria);
    }

    /**
     * Return a tablet based on the given product number
     *
     * @param productNumber the productNumber
     * @return Tablet instance based on the given productNumber
     * @throws EntityNotFoundException if the tablet is not found with given product number
     */
    public ServiceResult<Tablet> getTablet(String productNumber) throws EntityNotFoundException {
        Tablet tablet = tabletDAO.findById(productNumber);
        if(tablet == null) {
            throw new EntityNotFoundException("Tablet not found with the given product number");
        }
        return new ServiceResult<Tablet>(tablet);
    }
}

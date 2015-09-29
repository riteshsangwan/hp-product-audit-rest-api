/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.services;

import com.google.inject.Inject;
import com.hp.inventory.audit.rest.service.config.ApiConfiguration;
import com.hp.inventory.audit.rest.service.core.Printer;
import com.hp.inventory.audit.rest.service.core.PrinterSearchCriteria;
import com.hp.inventory.audit.rest.service.core.ServiceResult;
import com.hp.inventory.audit.rest.service.dao.PrinterDAO;
import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import com.hp.inventory.audit.rest.service.exceptions.EntityNotFoundException;
import io.dropwizard.validation.Validated;

import javax.inject.Named;

/**
 * Provides a contract between PrinterDAO and '/printers' endpoints
 *
 * @author TCSCODER
 * @version 1.0
 */
public class PrinterService {

    private final PrinterDAO printerDAO;
    private final ApiConfiguration apiConfiguration;

    /**
     * Default constructor. Whenever an instance of this class is created 'juice' will make sure that all the dependencies are properly injected
     * @param   printerDAO                              DAO implementation for this service
     * @param   apiConfiguration                        commons api configuration instance
     */
    @Inject
    public PrinterService(PrinterDAO printerDAO, @Validated @Named(ApiConfiguration.NAMED_BINDING) ApiConfiguration apiConfiguration) {
        this.printerDAO = printerDAO;
        this.apiConfiguration = apiConfiguration;
    }

    public ServiceResult<Printer> getPrinters(PrinterSearchCriteria criteria) throws ApiException {
        // set default limit
        if(criteria.getLimit() == null) {
            criteria.setLimit(apiConfiguration.getDefaultLimit());
        }
        return printerDAO.search(criteria);
    }

    /**
     * Return a printer based on the given product number
     *
     * @param productNumber the productNumber
     * @return Printer instnace based on the given productNumber
     * @throws ApiException if any exception occurs
     * @throws EntityNotFoundException if the printer is not found with given product number
     */
    public ServiceResult<Printer> getPrinter(String productNumber) throws ApiException, EntityNotFoundException {
        Printer printer = printerDAO.findById(productNumber);
        if(printer == null) {
            throw new EntityNotFoundException("Printer not found with the given product number");
        }
        return new ServiceResult<Printer>(printer);
    }
}

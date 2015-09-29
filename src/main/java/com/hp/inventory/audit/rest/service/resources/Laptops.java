/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.hp.inventory.audit.rest.service.annotations.QueryParams;
import com.hp.inventory.audit.rest.service.annotations.SearchCriteriaParam;
import com.hp.inventory.audit.rest.service.core.ApiResponse;
import com.hp.inventory.audit.rest.service.core.Payload;
import com.hp.inventory.audit.rest.service.core.SearchCriteria;
import com.hp.inventory.audit.rest.service.core.ServiceResult;
import com.hp.inventory.audit.rest.service.core.Laptop;
import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import com.hp.inventory.audit.rest.service.services.LaptopService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * jersey resource class for laptops endpoint
 * Only the application/json MIME type is supported.
 *
 * @author              TCSCODER
 * @version             1.0
 */
@Path("/api/v1/laptops")
@Produces(MediaType.APPLICATION_JSON)
public class Laptops {

    private final LaptopService service;

    /**
     * Default public constructor. Whenever an instance of this class is created, singleton instance of LaptopService is injected by guice.
     * @param   service                 LaptopService singleton instance
     * @since   1.0
     */
    @Inject
    public Laptops(LaptopService service) {
        this.service = service;
    }

    @GET
    @Timed
    @ExceptionMetered
    @QueryParams(fields = {"productNumber", "version", "currency", "currentPrice", "hpDataSheet", "parseDate", "productName", "productUrl", "rating", "strikedPrice",
            "battery", "batteryLife", "color", "dimensionDepthInInches", "dimensionHeightInInches", "dimensionWidthInInches", "dimensions", "display", "energyEfficiency",
            "expansionSlots", "graphics", "hardDrive", "keyboard", "maxBatteryLifeInHours", "memory", "modelNumber", "networking", "operatingSystem", "poitingDevices", "ports",
            "powerSupply", "processor", "softwareIncluded", "warranty", "webcam", "weight", "weightInPounds", "acAdapter", "accessories", "additionalBay", "audio",
            "bluetooth", "broadbandServiceProvider", "chipset", "externalIOPorts", "fingerPrintReader", "flashCache", "hpMobileBroadband", "labelEnergyStar", "laplinkPcmoverSoftware",
            "securitySoftware", "memorySlots", "miniCard", "miniCardSsd", "miscWarrantyDocumentation", "modem", "nearFieldCommunication", "osRecoveryCd", "officeSoftware",
            "opticalDrive", "outOfBandManagement", "personalization", "powerCord", "processorFamily", "processorTechnology", "recoveryMediaDriver", "securityManagement",
            "sensors", "theftProtection", "warrantyBattery", "boxContents", "wirelessLan"}, sortColumns = {"currentPrice", "productName", "rating"})
    public ApiResponse getLaptops(@SearchCriteriaParam SearchCriteria criteria) throws ApiException {
        ServiceResult<Laptop> result = service.getLaptops(criteria);
        return ApiResponse.buildWithPayload(new Payload<Laptop>().addObjectsToList(result.getResults()).setCursor(result.getCursor())).setStatus(Response.Status.OK);
    }

    @GET
    @Timed
    @ExceptionMetered
    @Path("/{productNumber}")
    public ApiResponse getLaptop(@PathParam("productNumber") String productNumber) throws ApiException {
        ServiceResult<Laptop> result = service.getLaptop(productNumber);
        return ApiResponse.buildWithPayload(new Payload<Laptop>().addObject(result.getResult())).setStatus(Response.Status.OK);
    }

}

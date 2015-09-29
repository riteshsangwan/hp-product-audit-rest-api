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
import com.hp.inventory.audit.rest.service.core.Tablet;
import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import com.hp.inventory.audit.rest.service.services.TabletService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * jersey resource class for tablets endpoint
 * Only the application/json MIME type is supported.
 *
 * @author              TCSCODER
 * @version             1.0
 */
@Path("/api/v1/tablets")
@Produces(MediaType.APPLICATION_JSON)
public class Tablets {

    private final TabletService service;

    /**
     * Default public constructor. Whenever an instance of this class is created, singleton instance of TabletService is injected by guice.
     * @param   service                 TabletService singleton instance
     * @since   1.0
     */
    @Inject
    public Tablets(TabletService service) {
        this.service = service;
    }

    @GET
    @Timed
    @ExceptionMetered
    @QueryParams(fields = {"productNumber", "version", "currency", "currentPrice", "hpDataSheet", "parseDate", "productName", "productUrl", "rating", "strikedPrice", "audio",
            "battery", "batteryLife", "color", "dimensionDepthInInches", "dimensionHeightInInches", "dimensionWidthInInches", "dimensions", "display", "expansionSlots",
            "integratedCamera", "internalStorage", "maxBatteryLifeInHours", "memory", "modelNumber", "operatingSystem", "ports", "processor", "sensors", "softwareIncluded", "warranty",
            "weight", "wireless", "chipset", "energyEfficiency", "graphics", "internalDrive", "powerSupply", "processorFamily", "processorTechnology", "securityManagement",
            "whatsInTheBox", "weightInPounds"}, sortColumns = {"currentPrice", "productName", "rating"})
    public ApiResponse getTablets(@SearchCriteriaParam SearchCriteria criteria) throws ApiException {
        ServiceResult<Tablet> result = service.getTablets(criteria);
        return ApiResponse.buildWithPayload(new Payload<Tablet>().addObjectsToList(result.getResults()).setCursor(result.getCursor())).setStatus(Response.Status.OK);
    }

    @GET
    @Timed
    @ExceptionMetered
    @Path("/{productNumber}")
    public ApiResponse getTablet(@PathParam("productNumber") String productNumber) throws ApiException {
        ServiceResult<Tablet> result = service.getTablet(productNumber);
        return ApiResponse.buildWithPayload(new Payload<Tablet>().addObject(result.getResult())).setStatus(Response.Status.OK);
    }

}

/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.hp.inventory.audit.rest.service.annotations.QueryParams;
import com.hp.inventory.audit.rest.service.annotations.SearchCriteriaParam;
import com.hp.inventory.audit.rest.service.core.ApiResponse;
import com.hp.inventory.audit.rest.service.core.Desktop;
import com.hp.inventory.audit.rest.service.core.Payload;
import com.hp.inventory.audit.rest.service.core.SearchCriteria;
import com.hp.inventory.audit.rest.service.core.ServiceResult;
import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import com.hp.inventory.audit.rest.service.services.DesktopService;

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
@Path("/api/v1/desktops")
@Produces(MediaType.APPLICATION_JSON)
public class Desktops {

    private final DesktopService service;

    /**
     * Default public constructor. Whenever an instance of this class is created, singleton instance of TabletService is injected by guice.
     * @param   service                 TabletService singleton instance
     * @since   1.0
     */
    @Inject
    public Desktops(DesktopService service) {
        this.service = service;
    }

    @GET
    @Timed
    @ExceptionMetered
    @QueryParams(fields = {"productNumber", "version", "currency", "currentPrice", "hpDataSheet", "parseDate", "productName", "productUrl",
            "rating", "strikedPrice", "audio", "color", "dimensionDepthInInches", "dimensionHeightInInches", "dimensionWidthInInches", "dimensions",
            "energyEfficiency", "expansionSlots", "externalIOPorts", "graphics", "hardDrive", "keyboard", "memory", "memorySlots", "modelNumber", "networking",
            "officeSoftware", "operatingSystem", "opticalDrive", "photographySoftware", "pointingDevices", "popularSoftware", "ports", "powerSupply",
            "processor", "softwareIncluded", "softwareUpgrades", "soundCard", "tvTurner", "warranty", "weight", "weightInPounds", "accessories", "additionalApplicationSoftware",
            "additionalNetworkingOptions", "battery", "batteryLife", "cableOptionKits", "chassis", "chinaCccCompliance", "controller", "display", "displayCable",
            "energyStar", "eightInternalStorage", "externalOpticalDrive", "fempCompliance", "fifthInternalStorage", "flashCache", "fourthInternalStorage", "graphicsConnectors",
            "highPerformanceGpuComputing", "integratedCamera", "intelSrtDiskCacheModules", "intelSmartResponseTechnology", "internalOsLoadStorageOptions", "internalPcieStorage",
            "internalStorageOptions", "lanTransceivers", "label", "maximumMemory", "securitySoftware", "mediaReader", "memoryCardDevice", "processorTechnology", "realTimeDataBackup",
            "secondDisplayCable", "secondGraphicsCard", "secondInternalStorage", "secondaryInternalPcieStorage", "secondaryOpticalDrive", "secondaryProcessor", "security",
            "securityEncryption", "sixthInternalStorage", "seventhInternalStorage", "softwareBundles", "speakers", "stand", "systemRecoverySolutions", "tvTuner",
            "technical", "technicalAV", "thirdGraphicsCard", "thirdInternalStorage", "webcam", "wireless"}, sortColumns = {"currentPrice", "productName", "rating"})
    public ApiResponse getTablets(@SearchCriteriaParam SearchCriteria criteria) throws ApiException {
        ServiceResult<Desktop> result = service.getDesktops(criteria);
        return ApiResponse.buildWithPayload(new Payload<Desktop>().addObjectsToList(result.getResults()).setCursor(result.getCursor())).setStatus(Response.Status.OK);
    }

    @GET
    @Timed
    @ExceptionMetered
    @Path("/{productNumber}")
    public ApiResponse getTablet(@PathParam("productNumber") String productNumber) throws ApiException {
        ServiceResult<Desktop> result = service.getDesktop(productNumber);
        return ApiResponse.buildWithPayload(new Payload<Desktop>().addObject(result.getResult())).setStatus(Response.Status.OK);
    }

}

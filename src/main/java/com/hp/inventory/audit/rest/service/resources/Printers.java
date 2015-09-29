/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.hp.inventory.audit.rest.service.annotations.PrinterSearchCriteriaParam;
import com.hp.inventory.audit.rest.service.annotations.QueryParams;
import com.hp.inventory.audit.rest.service.core.ApiResponse;
import com.hp.inventory.audit.rest.service.core.Payload;
import com.hp.inventory.audit.rest.service.core.Printer;
import com.hp.inventory.audit.rest.service.core.PrinterSearchCriteria;
import com.hp.inventory.audit.rest.service.core.ServiceResult;
import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import com.hp.inventory.audit.rest.service.services.PrinterService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * jersey resource class for '/printers' endpoint
 * Only the application/json MIME type is supported.
 *
 * @author              TCSCODER
 * @version             1.0
 */
@Path("/api/v1/printers")
@Produces(MediaType.APPLICATION_JSON)
public class Printers {

    private final PrinterService service;

    /**
     * Default public constructor. Whenever an instance of this class is created, singleton instance of PrinterService is injected by guice.
     * @param   service                 PrinterService singleton instance
     * @since   1.0
     */
    @Inject
    public Printers(PrinterService service) {
        this.service = service;
    }

    @GET
    @Timed
    @ExceptionMetered
    @QueryParams(fields = {"productNumber", "version", "currency", "currentPrice", "hpDataSheet", "parseDate", "productName", "productUrl",
            "type", "rating", "strikedPrice", "automaticPaperSensor", "borderlessPrinting", "cableIncluded", "compatibleInkTypes", "compatibleOperatingSystems",
            "connectivityOptional", "connectivityStd", "dimensionDepthInInches",
            "dimensionDepthInInchesMax", "dimensionHeightInInches", "dimensionHeightInInchesMax", "dimensionWidthInInches", "dimensionWidthInInchesMax",
            "dimensions", "dimensionsMax", "display", "duplexPrinting", "energyEfficiency", "envelopeInputCapacity",
            "fcc", "functions", "hardDisk", "mediaSizesCustom", "mediaSizesSupported", "mediaTypes", "mediaWeightsByPaperPath", "memoryMax",
            "memoryStd", "minimumSystemRequirements", "mobilePrintingCapability",
            "networkReady", "numberPrintCartridges", "operatingHumidityRange", "operatingTemperatureRange", "packageWeight", "packageWeightInPounds",
            "paperHandlingInputStd", "paperHandlingOutputStd", "paperTraysMax", "paperTraysStd", "postWarranty",
            "power", "powerConsumption", "printerManagement", "printLanguages", "printSpeedBlackDraft", "printSpeedBlackISO", "printSpeedColorDraft", "printSpeedColorISO",
            "printTechnology", "printerPageYield", "processorSpeed",
            "recommMonthlyPageVolume", "recommMonthlyPageVolumeMax", "recommMonthlyPageVolumeMin", "recommendedMediaWeight", "replacementCartridges", "resolutionBlack",
            "resolutionColor", "securityManagement", "softwareIncluded", "supportedMediaWeight", "supportedNetworkProtocols",
            "warranty", "weight", "weightInPounds", "whatsInTheBox", "adfCapacity", "autoDocumentFeeder", "batteryRechargeTime", "bitDepth", "broadcastLocations",
            "browserSupported", "colorStability", "connectivity", "controlPanel", "maximumCopies", "copyReduceEnlargeSettings", "copyResolutionBlackText",
            "copyResolutionColourTextGraphics", "copySpeedBlackDraft", "copySpeedBlackNormal", "copySpeedColorDraft", "copySpeedColorNormal",
            "digitalSendFileFormats", "digitalSendingFeatures", "duplexAdfScanning", "energyStar",
            "embeddedWebServer", "faxMemory", "faxResolution", "faxTransmissionSpeed", "faxing", "finishedOutputHandling", "firstPageOutBlack", "firstPageOutColor",
            "guaranteedMinimumLineWidth", "inputType", "lineAccuracy", "maximumDocumentScanSize", "maximumOpticalDensityBlack", "mptUsColorImageBestModeGlossy",
            "mptUsColorImageDraftModeCoated", "mptUsColorImageNormalModeCoated", "mptUsColorImageNormalModeGlossy",
            "mptBWLineDrawingDraftModePlain", "mptColorLineDrawingDraftModePlain", "mptLineDrawingEconomodePlain", "mediaThickness", "memoryCardCompatibility",
            "monthlyDutyCycle", "nonPrintableArea", "ports", "printRepeatability", "printSpeedMaximum", "resolution",
            "resolutionTechnology", "rollExternalDiameter", "rollMaximumOutput", "scanFileFormat", "scanResolutionHardware", "scanResolutionOptical",
            "scanSizeMaximum", "scanSizeFlatbedMaximum", "scanSpeedMaximum", "scannableMediaTypes", "scannerType",
            "speedDialsMaximumNumber", "usColorLineDrawingsDraftPlain"}, sortColumns = {"currentPrice", "productName", "rating"})
    public ApiResponse getPrinters(@PrinterSearchCriteriaParam PrinterSearchCriteria criteria) throws ApiException {
        ServiceResult<Printer> result = service.getPrinters(criteria);
        return ApiResponse.buildWithPayload(new Payload<Printer>().addObjectsToList(result.getResults()).setCursor(result.getCursor())).setStatus(Response.Status.OK);
    }

    @GET
    @Timed
    @ExceptionMetered
    @Path("/{productNumber}")
    public ApiResponse getPrinter(@PathParam("productNumber") String productNumber) throws ApiException {
        ServiceResult<Printer> result = service.getPrinter(productNumber);
        return ApiResponse.buildWithPayload(new Payload<Printer>().addObject(result.getResult())).setStatus(Response.Status.OK);
    }

}

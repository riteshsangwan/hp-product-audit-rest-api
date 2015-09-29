/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.hp.inventory.audit.rest.service.annotations.ProductSearchCriteriaParam;
import com.hp.inventory.audit.rest.service.annotations.QueryParams;
import com.hp.inventory.audit.rest.service.core.ApiResponse;
import com.hp.inventory.audit.rest.service.core.Payload;
import com.hp.inventory.audit.rest.service.core.Product;
import com.hp.inventory.audit.rest.service.core.ProductImage;
import com.hp.inventory.audit.rest.service.core.ProductSearchCriteria;
import com.hp.inventory.audit.rest.service.core.RelatedAccessory;
import com.hp.inventory.audit.rest.service.core.ServiceResult;
import com.hp.inventory.audit.rest.service.exceptions.ApiException;
import com.hp.inventory.audit.rest.service.services.ProductService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * jersey resource class for products endpoint
 * Only the application/json MIME type is supported.
 *
 * @author              TCSCODER
 * @version             1.0
 */
@Path("/api/v1/products")
@Produces(MediaType.APPLICATION_JSON)
public class Products {

    private final ProductService service;

    /**
     * Default public constructor. Whenever an instance of this class is created, singleton instance of ProductService is injected by guice.
     * @param   service                 ProductService singleton instance
     * @since   1.0
     */
    @Inject
    public Products(ProductService service) {
        this.service = service;
    }

    @GET
    @Timed
    @ExceptionMetered
    @QueryParams(fields = {"productNumber", "version", "auditTimeStamp", "id", "productName", "productUrl", "sourceFile", "productType",
        "currentPrice", "currency", "strikedPrice", "dateAdded", "previousPrice", "dateOfPriceChange", "rating", "previousRating",
        "numberOfReviews", "dateOfRatingChange", "parsingError", "dateOfParsingError", "comingSoonDate", "availableForSaleDate"}, sortColumns = {"currentPrice", "productName", "rating"})
    public ApiResponse getProducts(@ProductSearchCriteriaParam ProductSearchCriteria criteria) throws ApiException {
        ServiceResult<Product> result = service.getProducts(criteria);
        return ApiResponse.buildWithPayload(new Payload<Product>().addObjectsToList(result.getResults()).setCursor(result.getCursor())).setStatus(Response.Status.OK);
    }

    @GET
    @Timed
    @ExceptionMetered
    @Path("/{productNumber}")
    public ApiResponse getProduct(@PathParam("productNumber") String productNumber) throws ApiException {
        ServiceResult<Product> result = service.getProduct(productNumber);
        return ApiResponse.buildWithPayload(new Payload<Product>().addObject(result.getResult())).setStatus(Response.Status.OK);
    }

    @GET
    @Timed
    @ExceptionMetered
    @Path("/{productNumber}/images")
    public ApiResponse getProductImages(@PathParam("productNumber") String productNumber) throws ApiException {
        ServiceResult<ProductImage> result = service.getImages(productNumber);
        return ApiResponse.buildWithPayload(new Payload<ProductImage>().addObjectsToList(result.getResults())).setStatus(Response.Status.OK);
    }

    @GET
    @Timed
    @ExceptionMetered
    @Path("/{productNumber}/relatedaccessories")
    public ApiResponse getProductAccessories(@PathParam("productNumber") String productNumber) throws ApiException {
        ServiceResult<RelatedAccessory> result = service.getAccessories(productNumber);
        return ApiResponse.buildWithPayload(new Payload<RelatedAccessory>().addObjectsToList(result.getResults())).setStatus(Response.Status.OK);
    }

}

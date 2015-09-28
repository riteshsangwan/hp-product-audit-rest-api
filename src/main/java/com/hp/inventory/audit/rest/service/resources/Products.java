/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.resources;

import com.hp.inventory.audit.rest.service.services.ProductService;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * jersey resource class for products endpoint
 * Only the application/json MIME type is supported.
 *
 * @author              TCSCODER
 * @version             1.0
 */
@Path("/api/v1")
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

}

/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hp.inventory.audit.rest.service.Configuration;
import com.hp.inventory.audit.rest.service.config.ApiConfiguration;
import com.hp.inventory.audit.rest.service.core.Product;
import com.hp.inventory.audit.rest.service.core.ProductImage;
import com.hp.inventory.audit.rest.service.core.ProductSearchCriteria;
import com.hp.inventory.audit.rest.service.core.RelatedAccessory;
import com.hp.inventory.audit.rest.service.core.ServiceResult;
import com.hp.inventory.audit.rest.service.dao.ProductDAO;
import com.hp.inventory.audit.rest.service.exceptions.EntityNotFoundException;
import io.dropwizard.validation.Validated;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Provides a contract between ProductDAO and '/products' endpoints
 * @author              TCSCODER
 * @version             1.0
 */
@Singleton
public class ProductService {

    private final ProductDAO productDAO;
    private final Configuration configuration;
    private final ApiConfiguration apiConfiguration;

    /**
     * Default constructor. Whenever an instance of this class is created 'juice' will make sure that all the dependencies are properly injected
     * @param   productDAO                              DAO implementation for this service
     * @param   configuration                           Application configuration instance
     * @param   apiConfiguration                        commons api configuration instance
     */
    @Inject
    public ProductService(ProductDAO productDAO, @Validated Configuration configuration, @Validated @Named(ApiConfiguration.NAMED_BINDING) ApiConfiguration apiConfiguration) {
        this.productDAO = productDAO;
        this.apiConfiguration = apiConfiguration;
        this.configuration = configuration;
    }

    /**
     * Search the products based on the search criteria
     *
     * @param criteria the search criteria
     * @return Generic ServiceResult with embedded search results and search result cursor
     */
    public ServiceResult<Product> getProducts(ProductSearchCriteria criteria) {
        // set default limit
        if(criteria.getLimit() == null) {
            criteria.setLimit(apiConfiguration.getDefaultLimit());
        }
        return productDAO.search(criteria);
    }

    /**
     * Return a Product based on the given product number
     *
     * @param productNumber the productNumber
     * @return Tablet instance based on the given productNumber
     * @throws com.hp.inventory.audit.rest.service.exceptions.EntityNotFoundException if the tablet is not found with given product number
     */
    public ServiceResult<Product> getProduct(String productNumber) throws EntityNotFoundException {
        Product product = productDAO.findById(productNumber);
        if(product == null) {
            throw new EntityNotFoundException("Product not found with the given product number");
        }
        return new ServiceResult<Product>(product);
    }

    /**
     * Get related product images for a product
     *
     * @param productNumber the product number to get the images
     * @return Generic ServiceResult with embedded search results
     * @throws EntityNotFoundException if the given product number is not found
     */
    public ServiceResult<ProductImage> getImages(String productNumber) throws EntityNotFoundException {
        Collection<ProductImage> images = productDAO.getProductImages(productNumber);
        return new ServiceResult<ProductImage>(new ArrayList<ProductImage>(images), null);
    }

    /**
     * Get related product accessories for a product
     *
     * @param productNumber the product number to get the images
     * @return Generic ServiceResult with embedded search results
     * @throws EntityNotFoundException if the given product number is not found
     */
    public ServiceResult<RelatedAccessory> getAccessories(String productNumber) throws EntityNotFoundException {
        Collection<RelatedAccessory> accessories = productDAO.getProductAccessories(productNumber);
        return new ServiceResult<RelatedAccessory>(new ArrayList<RelatedAccessory>(accessories), null);
    }
}

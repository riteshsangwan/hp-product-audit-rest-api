/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * ProductImage Domain model which represents a product image
 *
 * @author TCSCODER
 * @version 1.0
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductImage implements Serializable {

    @Id
    private String url;

    @Version
    private Long version;


    private String productNumber;

    @ManyToOne
    @JoinColumn(name="productNumber", referencedColumnName = "productNumber", insertable = false, updatable = false)
    private Product product;

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        return getUrl().hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof ProductImage))
            return false;

        return getUrl().equals(((ProductImage) obj).getUrl());
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

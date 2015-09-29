/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Base class for all the products
 *
 * @author TCSCODER
 * @version 1.0
 */
@MappedSuperclass
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractProduct implements Serializable {
    @Id
    private String productNumber;

    @Version
    @GeneratedValue
    private Long version;

    @OneToOne
    @JoinColumn(name="productNumber")
    @Transient
    private Product product;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productNumber")
    private Collection<ProductImage> images;

    @Column(nullable = false)
    private Date parseDate;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String productUrl;

    private Double currentPrice;

    private Double strikedPrice;

    private String currency;

    private String hpDataSheet;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getHpDataSheet() {
        return hpDataSheet;
    }

    public void setHpDataSheet(String hpDataSheet) {
        this.hpDataSheet = hpDataSheet;
    }

    public Date getParseDate() {
        return parseDate;
    }

    public void setParseDate(Date parseDate) {
        this.parseDate = parseDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Collection<ProductImage> getImages() {
        return images;
    }

    public void setImages(Collection<ProductImage> images) {
        this.images = images;
    }

    public Double getStrikedPrice() {
        return strikedPrice;
    }

    public void setStrikedPrice(Double strikedPrice) {
        this.strikedPrice = strikedPrice;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * Product Domain model which represents a product
 *
 * @author TCSCODER
 * @version 1.0
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Serializable {
    @Id
    private String productNumber;

    @Version
    private Long version;

    private Date auditTimeStamp;
    private Date availableForSaleDate;
    private Date comingSoonDate;
    private String currency;
    private Double currentPrice;
    private Date dateAdded;
    private Date dateOfParsingError;
    private Date dateOfPriceChange;
    private Date dateOfRatingChange;
    private Integer id;
    private Integer numberOfReviews;
    private String parsingError;
    private Double previousPrice;
    private Integer previousRating;
    private String productName;
    private String productType;
    private String productUrl;
    private Integer rating;
    private String sourceFile;
    private Double strikedPrice;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productNumber")
    private Collection<ProductImage> images;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productNumber")
    private Set<RelatedAccessory> topAccessories;

    public Set<RelatedAccessory> getTopAccessories() {
        return topAccessories;
    }

    public void setTopAccessories(Set<RelatedAccessory> topAccessories) {
        this.topAccessories = topAccessories;
    }

    public Collection<ProductImage> getImages() {
        return images;
    }

    public void setImages(Collection<ProductImage> images) {
        this.images = images;
    }

    public Date getAvailableForSaleDate() {
        return availableForSaleDate;
    }

    public void setAvailableForSaleDate(Date availableForSaleDate) {
        this.availableForSaleDate = availableForSaleDate;
    }

    public Date getComingSoonDate() {
        return comingSoonDate;
    }

    public void setComingSoonDate(Date comingSoonDate) {
        this.comingSoonDate = comingSoonDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateOfParsingError() {
        return dateOfParsingError;
    }

    public void setDateOfParsingError(Date dateOfParsingError) {
        this.dateOfParsingError = dateOfParsingError;
    }

    public Date getDateOfPriceChange() {
        return dateOfPriceChange;
    }

    public void setDateOfPriceChange(Date dateOfPriceChange) {
        this.dateOfPriceChange = dateOfPriceChange;
    }

    public Date getDateOfRatingChange() {
        return dateOfRatingChange;
    }

    public void setDateOfRatingChange(Date dateOfRatingChange) {
        this.dateOfRatingChange = dateOfRatingChange;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public String getParsingError() {
        return parsingError;
    }

    public void setParsingError(String parsingError) {
        this.parsingError = parsingError;
    }

    public Double getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(Double previousPrice) {
        this.previousPrice = previousPrice;
    }

    public Integer getPreviousRating() {
        return previousRating;
    }

    public void setPreviousRating(Integer previousRating) {
        this.previousRating = previousRating;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Double getStrikedPrice() {
        return strikedPrice;
    }

    public void setStrikedPrice(Double strikedPrice) {
        this.strikedPrice = strikedPrice;
    }

    public Date getAuditTimeStamp() {
        return auditTimeStamp;
    }

    public void setAuditTimeStamp(Date dateTime) {
        this.auditTimeStamp = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getProductUrl() {
        return this.productUrl;
    }

    public void setProductUrl(String url) {
        this.productUrl = url;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

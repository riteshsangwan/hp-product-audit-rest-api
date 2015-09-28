/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import java.util.Date;
import java.util.List;

/**
 * Represents the search criteria for /products API's
 *
 * @author TCSCODER
 * @version 1.0
 */
public class ProductSearchCriteria extends SearchCriteria {

    /**
     * Represents the product type
     */
    private List<String> productType;
    /**
     * Represents the mininum value of auditTimestamp
     */
    private Date minAuditTimestamp;
    /**
     * Represents the maxinum value of auditTimestamp
     */
    private Date maxAuditTimestamp;
    /**
     * Represents the the mininum value of dateAdded
     */
    private Date minDateAdded;
    /**
     * Represents the the maxinum value of dateAdded
     */
    private Date maxDateAdded;
    /**
     * Represents the previousPrice
     */
    private Double previousPrice;
    /**
     * Represents the the mininum value of dateOfPriceChange
     */
    private Date minDateOfPriceChange;
    /**
     * Represents the the maxinum value of dateOfPriceChange
     */
    private Date maxDateOfPriceChange;
    /**
     * Represents the previousRating
     */
    private Integer previousRating;
    /**
     * Represents the the mininum value of dateOfRatingChange
     */
    private Date minDateOfRatingChange;
    /**
     * Represents the the maxinum value of dateOfRatingChange
     */
    private Date maxDateOfRatingChange;
    /**
     * Represents the the mininum value of dateOfParsingError
     */
    private Date minDateOfParsingError;
    /**
     * Represents the the maxinum value of dateOfParsingError
     */
    private Date maxDateOfParsingError;
    /**
     * Represents the the mininum value of comingSoonDate
     */
    private Date minComingSoonDate;
    /**
     * Represents the the maxinum value of comingSoonDate
     */
    private Date maxComingSoonDate;
    /**
     * Represents the the mininum value of availableForSaleDate
     */
    private Date minAvailableForSaleDate;
    /**
     * Represents the the maxinum value of availableForSaleDate
     */
    private Date maxAvailableForSaleDate;

    /**
     * Gets the productType
     * @return the productType
     */
    public List<String> getProductType() {
        return productType;
    }

    /**
     * Sets the productType
     * @param productType the value to set to productType
     */
    public void setProductType(List<String> productType) {
        this.productType = productType;
    }

    /**
     * Gets the minAuditTimestamp
     * @return the minAuditTimestamp
     */
    public Date getMinAuditTimestamp() {
        return minAuditTimestamp;
    }

    /**
     * Sets the minAuditTimestamp
     * @param minAuditTimestamp the value to set to minAuditTimestamp
     */
    public void setMinAuditTimestamp(Date minAuditTimestamp) {
        this.minAuditTimestamp = minAuditTimestamp;
    }

    /**
     * Gets the maxAuditTimestamp
     * @return the maxAuditTimestamp
     */
    public Date getMaxAuditTimestamp() {
        return maxAuditTimestamp;
    }

    /**
     * Sets the maxAuditTimestamp
     * @param maxAuditTimestamp the value to set to maxAuditTimestamp
     */
    public void setMaxAuditTimestamp(Date maxAuditTimestamp) {
        this.maxAuditTimestamp = maxAuditTimestamp;
    }

    /**
     * Gets the minDateAdded
     * @return the minDateAdded
     */
    public Date getMinDateAdded() {
        return minDateAdded;
    }

    /**
     * Sets the minDateAdded
     * @param minDateAdded the value to set to minDateAdded
     */
    public void setMinDateAdded(Date minDateAdded) {
        this.minDateAdded = minDateAdded;
    }

    /**
     * Gets the maxDateAdded
     * @return the maxDateAdded
     */
    public Date getMaxDateAdded() {
        return maxDateAdded;
    }

    /**
     * Sets the maxDateAdded
     * @param maxDateAdded the value to set to maxDateAdded
     */
    public void setMaxDateAdded(Date maxDateAdded) {
        this.maxDateAdded = maxDateAdded;
    }

    /**
     * Gets the previousPrice
     * @return the previousPrice
     */
    public Double getPreviousPrice() {
        return previousPrice;
    }

    /**
     * Sets the previousPrice
     * @param previousPrice the value to set to previousPrice
     */
    public void setPreviousPrice(Double previousPrice) {
        this.previousPrice = previousPrice;
    }

    /**
     * Gets the minDateOfPriceChange
     * @return the minDateOfPriceChange
     */
    public Date getMinDateOfPriceChange() {
        return minDateOfPriceChange;
    }

    /**
     * Sets the minDateOfPriceChange
     * @param minDateOfPriceChange the value to set to minDateOfPriceChange
     */
    public void setMinDateOfPriceChange(Date minDateOfPriceChange) {
        this.minDateOfPriceChange = minDateOfPriceChange;
    }

    /**
     * Gets the maxDateOfPriceChange
     * @return the maxDateOfPriceChange
     */
    public Date getMaxDateOfPriceChange() {
        return maxDateOfPriceChange;
    }

    /**
     * Sets the maxDateOfPriceChange
     * @param maxDateOfPriceChange the value to set to maxDateOfPriceChange
     */
    public void setMaxDateOfPriceChange(Date maxDateOfPriceChange) {
        this.maxDateOfPriceChange = maxDateOfPriceChange;
    }

    /**
     * Gets the previousRating
     * @return the previousRating
     */
    public Integer getPreviousRating() {
        return previousRating;
    }

    /**
     * Sets the previousRating
     * @param previousRating the value to set to previousRating
     */
    public void setPreviousRating(Integer previousRating) {
        this.previousRating = previousRating;
    }

    /**
     * Gets the minDateOfRatingChange
     * @return the minDateOfRatingChange
     */
    public Date getMinDateOfRatingChange() {
        return minDateOfRatingChange;
    }

    /**
     * Sets the minDateOfRatingChange
     * @param minDateOfRatingChange the value to set to minDateOfRatingChange
     */
    public void setMinDateOfRatingChange(Date minDateOfRatingChange) {
        this.minDateOfRatingChange = minDateOfRatingChange;
    }

    /**
     * Gets the maxDateOfRatingChange
     * @return the maxDateOfRatingChange
     */
    public Date getMaxDateOfRatingChange() {
        return maxDateOfRatingChange;
    }

    /**
     * Sets the maxDateOfRatingChange
     * @param maxDateOfRatingChange the value to set to maxDateOfRatingChange
     */
    public void setMaxDateOfRatingChange(Date maxDateOfRatingChange) {
        this.maxDateOfRatingChange = maxDateOfRatingChange;
    }

    /**
     * Gets the minDateOfParsingError
     * @return the minDateOfParsingError
     */
    public Date getMinDateOfParsingError() {
        return minDateOfParsingError;
    }

    /**
     * Sets the minDateOfParsingError
     * @param minDateOfParsingError the value to set to minDateOfParsingError
     */
    public void setMinDateOfParsingError(Date minDateOfParsingError) {
        this.minDateOfParsingError = minDateOfParsingError;
    }

    /**
     * Gets the maxDateOfParsingError
     * @return the maxDateOfParsingError
     */
    public Date getMaxDateOfParsingError() {
        return maxDateOfParsingError;
    }

    /**
     * Sets the maxDateOfParsingError
     * @param maxDateOfParsingError the value to set to maxDateOfParsingError
     */
    public void setMaxDateOfParsingError(Date maxDateOfParsingError) {
        this.maxDateOfParsingError = maxDateOfParsingError;
    }

    /**
     * Gets the minComingSoonDate
     * @return the minComingSoonDate
     */
    public Date getMinComingSoonDate() {
        return minComingSoonDate;
    }

    /**
     * Sets the minComingSoonDate
     * @param minComingSoonDate the value to set to minComingSoonDate
     */
    public void setMinComingSoonDate(Date minComingSoonDate) {
        this.minComingSoonDate = minComingSoonDate;
    }

    /**
     * Gets the maxComingSoonDate
     * @return the maxComingSoonDate
     */
    public Date getMaxComingSoonDate() {
        return maxComingSoonDate;
    }

    /**
     * Sets the maxComingSoonDate
     * @param maxComingSoonDate the value to set to maxComingSoonDate
     */
    public void setMaxComingSoonDate(Date maxComingSoonDate) {
        this.maxComingSoonDate = maxComingSoonDate;
    }

    /**
     * Gets the minAvailableForSaleDate
     * @return the minAvailableForSaleDate
     */
    public Date getMinAvailableForSaleDate() {
        return minAvailableForSaleDate;
    }

    /**
     * Sets the minAvailableForSaleDate
     * @param minAvailableForSaleDate the value to set to minAvailableForSaleDate
     */
    public void setMinAvailableForSaleDate(Date minAvailableForSaleDate) {
        this.minAvailableForSaleDate = minAvailableForSaleDate;
    }

    /**
     * Gets the maxAvailableForSaleDate
     * @return the maxAvailableForSaleDate
     */
    public Date getMaxAvailableForSaleDate() {
        return maxAvailableForSaleDate;
    }

    /**
     * Sets the maxAvailableForSaleDate
     * @param maxAvailableForSaleDate the value to set to maxAvailableForSaleDate
     */
    public void setMaxAvailableForSaleDate(Date maxAvailableForSaleDate) {
        this.maxAvailableForSaleDate = maxAvailableForSaleDate;
    }
}

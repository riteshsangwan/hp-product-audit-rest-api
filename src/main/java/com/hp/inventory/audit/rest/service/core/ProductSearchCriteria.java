/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
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
     * Represents the mininum value of auditTimeStamp
     */
    private Date minAuditTimeStamp;
    /**
     * Represents the maxinum value of auditTimeStamp
     */
    private Date maxAuditTimeStamp;
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
    public void setProductType(String productType) {
        if(StringUtils.isNotBlank(productType)) {
            this.productType = Arrays.asList(productType.split(","));
        }
    }

    /**
     * Gets the minAuditTimeStamp
     * @return the minAuditTimeStamp
     */
    public Date getMinAuditTimeStamp() {
        return minAuditTimeStamp;
    }

    /**
     * Sets the minAuditTimeStamp
     * @param minAuditTimeStamp the value to set to minAuditTimeStamp
     */
    public void setMinAuditTimeStamp(String minAuditTimeStamp) {
        if(StringUtils.isNotBlank(minAuditTimeStamp)) {
            try {
                long millis = Long.parseLong(minAuditTimeStamp);
                this.minAuditTimeStamp = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("minAuditTimeStamp should be a valid date", nfe);
            }
        }
    }

    /**
     * Gets the maxAuditTimeStamp
     * @return the maxAuditTimeStamp
     */
    public Date getMaxAuditTimeStamp() {
        return maxAuditTimeStamp;
    }

    /**
     * Sets the maxAuditTimeStamp
     * @param maxAuditTimeStamp the value to set to maxAuditTimeStamp
     */
    public void setMaxAuditTimeStamp(String maxAuditTimeStamp) {
        if(StringUtils.isNotBlank(maxAuditTimeStamp)) {
            try {
                long millis = Long.parseLong(maxAuditTimeStamp);
                this.maxAuditTimeStamp = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("maxAuditTimeStamp should be a valid date", nfe);
            }
        }
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
    public void setMinDateAdded(String minDateAdded) {
        if(StringUtils.isNotBlank(minDateAdded)) {
            try {
                long millis = Long.parseLong(minDateAdded);
                this.minDateAdded = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("minDateAdded should be a valid date", nfe);
            }
        }
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
    public void setMaxDateAdded(String maxDateAdded) {
        if(StringUtils.isNotBlank(maxDateAdded)) {
            try {
                long millis = Long.parseLong(maxDateAdded);
                this.maxDateAdded = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("maxDateAdded should be a valid date", nfe);
            }
        }
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
    public void setPreviousPrice(String previousPrice) {
        if(StringUtils.isNotBlank(previousPrice)) {
            try {
                this.previousPrice = Double.parseDouble(previousPrice);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("previousPrice should be a valid double value", nfe);
            }
        }
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
    public void setMinDateOfPriceChange(String minDateOfPriceChange) {
        if(StringUtils.isNotBlank(minDateOfPriceChange)) {
            try {
                long millis = Long.parseLong(minDateOfPriceChange);
                this.minDateOfPriceChange = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("minDateOfPriceChange should be a valid date", nfe);
            }
        }
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
    public void setMaxDateOfPriceChange(String maxDateOfPriceChange) {
        if(StringUtils.isNotBlank(maxDateOfPriceChange)) {
            try {
                long millis = Long.parseLong(maxDateOfPriceChange);
                this.maxDateOfPriceChange = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("maxDateOfPriceChange should be a valid date", nfe);
            }
        }
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
    public void setPreviousRating(String previousRating) {
        if(StringUtils.isNotBlank(previousRating)) {
            try {
                this.previousRating = Integer.parseInt(previousRating);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("previousRating should be a valid integer value", nfe);
            }
        }
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
    public void setMinDateOfRatingChange(String minDateOfRatingChange) {
        if(StringUtils.isNotBlank(minDateOfRatingChange)) {
            try {
                long millis = Long.parseLong(minDateOfRatingChange);
                this.minDateOfRatingChange = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("minDateOfRatingChange should be a valid date", nfe);
            }
        }
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
    public void setMaxDateOfRatingChange(String maxDateOfRatingChange) {
        if(StringUtils.isNotBlank(maxDateOfRatingChange)) {
            try {
                long millis = Long.parseLong(maxDateOfRatingChange);
                this.maxDateOfRatingChange = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("maxDateOfRatingChange should be a valid date", nfe);
            }
        }
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
    public void setMinDateOfParsingError(String minDateOfParsingError) {
        if(StringUtils.isNotBlank(minDateOfParsingError)) {
            try {
                long millis = Long.parseLong(minDateOfParsingError);
                this.minDateOfParsingError = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("minDateOfParsingError should be a valid date", nfe);
            }
        }
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
    public void setMaxDateOfParsingError(String maxDateOfParsingError) {
        if(StringUtils.isNotBlank(maxDateOfParsingError)) {
            try {
                long millis = Long.parseLong(maxDateOfParsingError);
                this.maxDateOfParsingError = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("maxDateOfParsingError should be a valid date", nfe);
            }
        }
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
    public void setMinComingSoonDate(String minComingSoonDate) {
        if(StringUtils.isNotBlank(minComingSoonDate)) {
            try {
                long millis = Long.parseLong(minComingSoonDate);
                this.minComingSoonDate = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("minComingSoonDate should be a valid date", nfe);
            }
        }
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
    public void setMaxComingSoonDate(String maxComingSoonDate) {
        if(StringUtils.isNotBlank(maxComingSoonDate)) {
            try {
                long millis = Long.parseLong(maxComingSoonDate);
                this.maxComingSoonDate = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("maxComingSoonDate should be a valid date", nfe);
            }
        }
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
    public void setMinAvailableForSaleDate(String minAvailableForSaleDate) {
        if(StringUtils.isNotBlank(minAvailableForSaleDate)) {
            try {
                long millis = Long.parseLong(minAvailableForSaleDate);
                this.minAvailableForSaleDate = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("minComingSoonDate should be a valid date", nfe);
            }
        }
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
    public void setMaxAvailableForSaleDate(String maxAvailableForSaleDate) {
        if(StringUtils.isNotBlank(maxAvailableForSaleDate)) {
            try {
                long millis = Long.parseLong(maxAvailableForSaleDate);
                this.maxAvailableForSaleDate = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("maxAvailableForSaleDate should be a valid date", nfe);
            }
        }
    }
}

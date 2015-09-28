/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import java.util.Date;
import java.util.List;

/**
 * Represents the base search criteria for list API's
 *
 * @author TCSCODER
 * @version 1.0
 */
public class SearchCriteria extends PartialResponse {

    /**
     * Represents the min current price
     */
    private Double minCurrentPrice;
    /**
     * Represents the max current price
     */
    private Double maxCurrentPrice;
    /**
     * Represents the rating
     * This is a multi-valued search crieria
     */
    private List<Integer> rating;
    /**
     * Represents the min parse date
     */
    private Date minParseDate;
    /**
     * Represents the max parse date
     */
    private Date maxParseDate;
    /**
     * Flag to indicate whether to include referenced product images
     */
    private Boolean images;
    /**
     * Flag to indicate whether to include referenced product accessories
     */
    private Boolean ra;

    /**
     * Gets the minCurrentPrice
     * @return the minCurrentPrice
     */
    public Double getMinCurrentPrice() {
        return minCurrentPrice;
    }

    /**
     * Sets the minCurrentPrice
     * @param minCurrentPrice the value to set to minCurrentPrice
     */
    public void setMinCurrentPrice(Double minCurrentPrice) {
        this.minCurrentPrice = minCurrentPrice;
    }

    /**
     * Gets the maxCurrentPrice
     * @return the maxCurrentPrice
     */
    public Double getMaxCurrentPrice() {
        return maxCurrentPrice;
    }

    /**
     * Sets the maxCurrentPrice
     * @param maxCurrentPrice the value to set to maxCurrentPrice
     */
    public void setMaxCurrentPrice(Double maxCurrentPrice) {
        this.maxCurrentPrice = maxCurrentPrice;
    }

    /**
     * Gets the rating
     * @return the rating
     */
    public List<Integer> getRating() {
        return rating;
    }

    /**
     * Sets the rating
     * @param rating the value to set to rating
     */
    public void setRating(List<Integer> rating) {
        this.rating = rating;
    }

    /**
     * Gets the minParseDate
     * @return the minParseDate
     */
    public Date getMinParseDate() {
        return minParseDate;
    }

    /**
     * Sets the minParseDate
     * @param minParseDate the value to set to minParseDate
     * @throws java.lang.IllegalArgumentException if the parameter is not a valid representation of long
     */
    public void setMinParseDate(String minParseDate) {
        try {
            long millis = Long.parseLong(minParseDate);
            this.minParseDate = new Date(millis);
        } catch(NumberFormatException nfe) {
            throw new IllegalArgumentException("minParseDate should be a valid date", nfe);
        }
    }

    /**
     * Gets the maxParseDate
     * @return the maxParseDate
     */
    public Date getMaxParseDate() {
        return maxParseDate;
    }

    /**
     * Sets the maxParseDate
     * @param maxParseDate the value to set to maxParseDate
     * @throws java.lang.IllegalArgumentException if the parameter is not a valid representation of long
     */
    public void setMaxParseDate(String maxParseDate) {
        try {
            long millis = Long.parseLong(maxParseDate);
            this.minParseDate = new Date(millis);
        } catch(NumberFormatException nfe) {
            throw new IllegalArgumentException("maxParseDate should be a valid date", nfe);
        }
    }

    /**
     * Gets the images
     * @return the images
     */
    public Boolean getImages() {
        return images;
    }

    /**
     * Sets the images
     * @param images the value to set to images
     */
    public void setImages(Boolean images) {
        this.images = images;
    }

    /**
     * Gets the ra
     * @return the ra
     */
    public Boolean getRa() {
        return ra;
    }

    /**
     * Sets the minCurrentPrice
     * @param ra the value to set to ra
     */
    public void setRa(Boolean ra) {
        this.ra = ra;
    }
}

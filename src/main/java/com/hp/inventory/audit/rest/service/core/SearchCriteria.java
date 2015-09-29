/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
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
        return this.minCurrentPrice;
    }

    /**
     * Sets the minCurrentPrice
     * @param minCurrentPrice the value to set to minCurrentPrice
     */
    public void setMinCurrentPrice(String minCurrentPrice) {
        if(StringUtils.isNotBlank(minCurrentPrice)) {
            try {
                this.minCurrentPrice = Double.parseDouble(minCurrentPrice);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("minCurrentPrice should be a valid double value", nfe);
            }
        }
    }

    /**
     * Gets the maxCurrentPrice
     * @return the maxCurrentPrice
     */
    public Double getMaxCurrentPrice() {
        return this.maxCurrentPrice;
    }

    /**
     * Sets the maxCurrentPrice
     * @param maxCurrentPrice the value to set to maxCurrentPrice
     */
    public void setMaxCurrentPrice(String maxCurrentPrice) {
        if(StringUtils.isNotBlank(maxCurrentPrice)) {
            try {
                this.maxCurrentPrice = Double.parseDouble(maxCurrentPrice);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("maxCurrentPrice should be a valid double value", nfe);
            }
        }
    }

    /**
     * Gets the rating
     * @return the rating
     */
    public List<Integer> getRating() {
        return this.rating;
    }

    /**
     * Sets the rating
     * @param rating the value to set to rating
     */
    public void setRating(String rating) {
        if(StringUtils.isNotBlank(rating)) {
            String[] parts = rating.split(",");
            this.rating = new ArrayList<Integer>();
            for(String part: parts) {
                try {
                    this.rating.add(Integer.parseInt(part));
                } catch(NumberFormatException nfe) {
                    throw new IllegalArgumentException(part + " is not a valid rating value. Rating can only be integers", nfe);
                }
            }
        }
    }

    /**
     * Gets the minParseDate
     * @return the minParseDate
     */
    public Date getMinParseDate() {
        return this.minParseDate;
    }

    /**
     * Sets the minParseDate
     * @param minParseDate the value to set to minParseDate
     * @throws java.lang.IllegalArgumentException if the parameter is not a valid representation of long
     */
    public void setMinParseDate(String minParseDate) {
        if(StringUtils.isNotBlank(minParseDate)) {
            try {
                long millis = Long.parseLong(minParseDate);
                this.minParseDate = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("minParseDate should be a valid date", nfe);
            }
        }
    }

    /**
     * Gets the maxParseDate
     * @return the maxParseDate
     */
    public Date getMaxParseDate() {
        return this.maxParseDate;
    }

    /**
     * Sets the maxParseDate
     * @param maxParseDate the value to set to maxParseDate
     * @throws java.lang.IllegalArgumentException if the parameter is not a valid representation of long
     */
    public void setMaxParseDate(String maxParseDate) {
        if(StringUtils.isNotBlank(maxParseDate)) {
            try {
                long millis = Long.parseLong(maxParseDate);
                this.maxParseDate = new Date(millis);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("maxParseDate should be a valid date", nfe);
            }
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
    public void setImages(String images) {
        if(StringUtils.isNotBlank(images)) {
            try {
                this.images = Boolean.parseBoolean(images);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException(images + "is not a valid images value. Valid values are 'true' or 'false'", nfe);
            }
        }
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
    public void setRa(String ra) {
        if(StringUtils.isNotBlank(ra)) {
            try {
                this.ra = Boolean.parseBoolean(ra);
            } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException(ra + "is not a valid images value. Valid values are 'true' or 'false'", nfe);
            }
        }
    }
}

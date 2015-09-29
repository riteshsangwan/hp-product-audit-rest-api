/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;

/**
 * Product Domain model which represents a product
 *
 * @author TCSCODER
 * @version 1.0
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Serializable {
    private Integer id;

    @Version
    private Long version;

    @Id
    private String productNumber;
    private String productUrl;
    private String sourceFile;
    private Date auditTimeStamp;

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

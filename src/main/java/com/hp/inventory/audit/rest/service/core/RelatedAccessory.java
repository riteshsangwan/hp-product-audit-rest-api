/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * Represent a product accessory
 *
 * @author TCSCODER
 * @version 1.0
 */
@Entity
@IdClass(RelatedAccessoryPK.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedAccessory implements Serializable {
    @Id
    private String url;

    @Id
    private String productNumber;

    @Version
    private Long version;


    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="productNumber", insertable = false, updatable = false)
    private Product product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        return new HashCodeBuilder().append(url).append(productNumber).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof RelatedAccessory))
            return false;

        RelatedAccessory that = (RelatedAccessory) obj;

        return new EqualsBuilder().append(url, that.url).append(productNumber, that.productNumber).isEquals();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
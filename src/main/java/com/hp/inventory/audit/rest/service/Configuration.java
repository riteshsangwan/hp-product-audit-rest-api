/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service;

import com.hp.inventory.audit.rest.service.config.ApiConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Application configuration file.
 * It is a sub class of dropwizard Configuration class.
 * While running the configured commands the configuration file is parsed by the dropwizard and an instance of this class is created and validated,
 * after validation the instance is passed to Application class.
 * Internally dropwizard uses jackson to parse the file. Dropwizard will look for 'yml' and 'yaml' file extension and if both of these are missing
 * then dropwizard will try to parse the file as json file.
 *
 * @author              TCSCODER
 * @version             1.0
 */
public class Configuration extends io.dropwizard.Configuration {
    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.database = dataSourceFactory;
    }

    @Valid
    @NotNull
    @JsonProperty("api")
    private ApiConfiguration apiConfiguration = new ApiConfiguration();

    /**
     * Returns the ApiConfiguration instance
     * @return              apiConfiguration                        ApiConfiguration instance
     * @since               1.0
     */
    public ApiConfiguration getApiConfiguration() {
        return apiConfiguration;
    }

    /**
     * Setter for ApiConfiguration instance
     * @return              apiConfiguration                        ApiConfiguration instance
     * @since               1.0
     */
    public void setApiConfiguration(ApiConfiguration apiConfiguration) {
        this.apiConfiguration = apiConfiguration;
    }
}

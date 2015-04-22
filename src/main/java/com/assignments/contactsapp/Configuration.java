package com.assignments.contactsapp;

import com.assignments.contactsapp.config.ApiConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Copyright 2015
 * Created by anurag on 20/4/15 5:51 PM.
 *
 * @author              anurag
 * @version             1.0
 *
 * Application configuration file.
 * It is a sub class of dropwizard Configuration class.
 * While running the configured commands the configuration file is parsed by the dropwizard and an instance of this class is created and validated,
 * after validation the instance is passed to Application class.
 * Internally dropwizard uses jackson to parse the file. Dropwizard will look for 'yml' and 'yaml' file extension and if both of these are missing
 * then dropwizard will try to parse the file as json file.
 *
 */
public class Configuration extends io.dropwizard.Configuration {
    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.database = dataSourceFactory;
    }

    @NotNull
    private long tokenExpirationInMillis;

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

    /**
     * Returns the token expiration duration in milli seconds
     * @return              tokenExpirationInMillis                 token expiration in milli seconds
     * @since               1.0
     */
    public long getTokenExpirationInMillis() {
        return tokenExpirationInMillis;
    }

    /**
     * Set the token expiration in milli seconds
     * @param               tokenExpirationInMillis                 token expiration in milli seconds
     * @since               1.0
     */
    public void setTokenExpirationInMillis(long tokenExpirationInMillis) {
        this.tokenExpirationInMillis = tokenExpirationInMillis;
    }
}

package com.assignments.contactsapp.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.inject.Singleton;

/**
 * Copyright 2015
 * Created by anurag on 22/4/15 04:46 AM.
 *
 * @author              anurag
 * @version             1.0
 */
@Singleton
public class ApiConfiguration {

    public static final String NAMED_BINDING = "com.assignments.contactsapp.config";

    @NotBlank
    @JsonProperty
    private String jwtSecret;

    @NotBlank
    @JsonProperty
    private String jwtAudience;

    public String getJwtSecret() {
        return jwtSecret;
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    public String getJwtAudience() {
        return jwtAudience;
    }

    public void setJwtAudience(String jwtAudience) {
        this.jwtAudience = jwtAudience;
    }
}

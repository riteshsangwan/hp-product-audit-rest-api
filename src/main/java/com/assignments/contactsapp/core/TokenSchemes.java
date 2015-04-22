package com.assignments.contactsapp.core;

/**
 * Copyright 2015
 * Created by anurag on 22/4/15 12:59 AM.
 *
 * @author              anurag
 * @version             1.0
 */
public enum TokenSchemes {

    BEARER("Bearer"),
    BASIC("Basic");

    private String scheme;
    TokenSchemes(String scheme) {
        this.scheme = scheme;
    }
    public String getScheme() {
        return this.scheme;
    }
}

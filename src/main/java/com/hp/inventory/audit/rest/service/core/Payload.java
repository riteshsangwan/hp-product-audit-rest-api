/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Jersey Response payload. Instances of this class is added as response entities
 *
 * @author              TCSCODER
 * @version             1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payload<T> {

    /**
     * Represents a list payload
     */
    private List<T> items;
    /**
     * Represents a single payload data
     */
    private T single;

    /**
     * Represents the search result cursor
     */
    private SearchResultCursor cursor;

    /**
     * Sets the search result cursor
     * @param cursor the search result cursor to set
     * @return this for chanining
     */
    public Payload<T> setCursor(SearchResultCursor cursor) {
        this.cursor = cursor;
        return this;
    }

    /**
     * Gets the data
     * @return the data
     */
    public List<T> getItems() {
        return this.items;
    }

    /**
     * Gets the single
     * @return the data
     */
    public T getSingle() {
        return this.single;
    }

    /**
     * Add an object to the single payload data
     * @param object the object to add
     * @return this to support chaining
     */
    public Payload<T> addObject(T object) {
        this.single = object;
        return this;
    }

    /**
     * Add an object to the list of payload data
     * @param object the object to add
     * @return this to support chaining
     */
    public Payload<T> addObjectToList(T object) {
        if(this.getItems() == null) {
            this.items = new ArrayList<T>();
        }
        this.getItems().add(object);
        return this;
    }

    /**
     * Add a list of objects to the list of payload data
     * @param objects the list of objects to add
     * @return this to support chaining
     */
    public Payload<T> addObjectsToList(List<T> objects) {
        if(this.getItems() == null) {
            this.items = new ArrayList<T>();
        }
        this.getItems().addAll(objects);
        return this;
    }

    /**
     * Gets the cursor
     * @return the cursor
     */
    public SearchResultCursor getCursor() {
        return this.cursor;
    }
}
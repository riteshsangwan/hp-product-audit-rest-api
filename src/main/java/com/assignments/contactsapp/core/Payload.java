package com.assignments.contactsapp.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2015
 * Created by Anurag on 20/4/15 11:50 PM.
 *
 * @author              anurag
 * @version             1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payload<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public Payload<T> addObject(T object) {
        if(this.getData() == null) {
            this.data = new ArrayList<T>();
        }
        this.getData().add(object);
        return this;
    }

    public Payload<T> addObjects(List<T> objects) {
        if(this.getData() == null) {
            this.data = new ArrayList<T>();
        }
        this.getData().addAll(objects);
        return this;
    }
}
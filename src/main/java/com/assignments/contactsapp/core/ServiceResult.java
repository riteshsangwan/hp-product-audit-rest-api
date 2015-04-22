package com.assignments.contactsapp.core;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright 2015
 * Created by anurag on 21/04/15 01:31 AM
 */
public class ServiceResult<M extends Serializable> {
    private List<M> result;

    public ServiceResult(List<M> result) {
        this.result = result;
    }

    public List<M> getResult() {
        return result;
    }
}

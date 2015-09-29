/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.annotations;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to specify valid query params passed to a resource method
 * @author TCSCODER
 * @version 1.0
 */
@java.lang.annotation.Target({ElementType.METHOD, ElementType.TYPE})
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@NameBinding
public @interface QueryParams {

    String[] fields() default {};
    String[] sortColumns() default {};
}

/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to inject an instance of SearchCriteria into resource class methods
 *
 * @author TCSCODER
 * @version 1.0
 */
@java.lang.annotation.Target(ElementType.PARAMETER)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface SearchCriteriaParam {
}

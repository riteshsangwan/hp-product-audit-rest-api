package com.assignments.contactsapp.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * Copyright 2015
 * Created by anurag on 22/4/15 01:38 AM.
 *
 * @author                  anurag
 * @version                 1.0s
 */
@java.lang.annotation.Target(ElementType.PARAMETER)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface AuthParam {
}
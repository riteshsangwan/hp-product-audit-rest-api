package com.assignments.contactsapp.commons.api.providers;

import com.assignments.contactsapp.core.AuthToken;
import com.assignments.contactsapp.factories.AuthTokenValueFactory;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;
import org.glassfish.jersey.server.internal.inject.AbstractValueFactoryProvider;
import org.glassfish.jersey.server.internal.inject.MultivaluedParameterExtractorProvider;
import org.glassfish.jersey.server.model.Parameter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.ext.Provider;

/**
 * Copyright 2015
 * Created by anurag on 20/4/15 1:20 PM.
 *
 * @author anurag
 */
@Provider
@Singleton
public class AuthParamValueFactoryProvider extends AbstractValueFactoryProvider {

    @Inject
    protected AuthParamValueFactoryProvider(MultivaluedParameterExtractorProvider mpep, ServiceLocator locator) {
        super(mpep, locator, Parameter.Source.UNKNOWN);
    }

    @Override
    protected AbstractContainerRequestValueFactory<?> createValueFactory(Parameter parameter) {
        Class<?> classType = parameter.getRawType();

        if (classType == null || (!classType.equals(AuthToken.class))) {
            return null;
        }
        return new AuthTokenValueFactory();
    }
}
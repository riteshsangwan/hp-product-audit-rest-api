/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.providers;

import com.hp.inventory.audit.rest.service.core.ProductSearchCriteria;
import com.hp.inventory.audit.rest.service.factories.ProductSearchCriteriaValueFactory;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;
import org.glassfish.jersey.server.internal.inject.AbstractValueFactoryProvider;
import org.glassfish.jersey.server.internal.inject.MultivaluedParameterExtractorProvider;
import org.glassfish.jersey.server.model.Parameter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.ext.Provider;

/**
 * Provides an instance of ProductSearchCriteriaValueFactory
 *
 * @author TCSCODER
 * @version 1.0
 */
@Provider
@Singleton
public class ProductSearchCriteriaParamValueFactoryProvider extends AbstractValueFactoryProvider {

    /**
     * {@inheritDoc}
     */
    @Inject
    protected ProductSearchCriteriaParamValueFactoryProvider(MultivaluedParameterExtractorProvider mpep, ServiceLocator locator) {
        super(mpep, locator, Parameter.Source.UNKNOWN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected AbstractContainerRequestValueFactory<?> createValueFactory(Parameter parameter) {
        Class<?> classType = parameter.getRawType();

        if (classType == null || (!classType.equals(ProductSearchCriteria.class))) {
            return null;
        }
        return new ProductSearchCriteriaValueFactory();
    }
}

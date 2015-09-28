/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.resolvers;

import com.hp.inventory.audit.rest.service.annotations.ProductSearchCriteriaParam;
import com.hp.inventory.audit.rest.service.providers.ProductSearchCriteriaParamValueFactoryProvider;
import org.glassfish.jersey.server.internal.inject.ParamInjectionResolver;
import org.glassfish.jersey.server.spi.internal.ValueFactoryProvider;

/**
 * Resolve ProductSearchCriteriaParam injection
 *
 * @author TCSCODER
 * @version 1.0
 */
public class ProductSearchCriteriaParamInjectionResolver extends ParamInjectionResolver<ProductSearchCriteriaParam> {

    /**
     * {@inheritDoc}
     */
    public ProductSearchCriteriaParamInjectionResolver(Class<? extends ValueFactoryProvider> valueFactoryProviderClass) {
        super(ProductSearchCriteriaParamValueFactoryProvider.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMethodParameterIndicator() {
        return true;
    }
}

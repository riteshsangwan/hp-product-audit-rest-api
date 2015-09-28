/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.resolvers;

import com.hp.inventory.audit.rest.service.annotations.SearchCriteriaParam;
import com.hp.inventory.audit.rest.service.providers.SearchCriteriaParamValueFactoryProvider;
import org.glassfish.jersey.server.internal.inject.ParamInjectionResolver;
import org.glassfish.jersey.server.spi.internal.ValueFactoryProvider;

/**
 * Resolve SearchCriteriaParam injection
 *
 * @author TCSCODER
 * @version 1.0
 */
public class SearchCriteriaParamInjectionResolver extends ParamInjectionResolver<SearchCriteriaParam> {

    /**
     * {@inheritDoc}
     */
    public SearchCriteriaParamInjectionResolver(Class<? extends ValueFactoryProvider> valueFactoryProviderClass) {
        super(SearchCriteriaParamValueFactoryProvider.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMethodParameterIndicator() {
        return true;
    }
}

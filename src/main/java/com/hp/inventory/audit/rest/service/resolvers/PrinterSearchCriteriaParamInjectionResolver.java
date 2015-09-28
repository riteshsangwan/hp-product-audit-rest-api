/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.resolvers;

import com.hp.inventory.audit.rest.service.annotations.PrinterSearchCriteriaParam;
import com.hp.inventory.audit.rest.service.providers.PrinterSearchCriteriaParamValueFactoryProvider;
import org.glassfish.jersey.server.internal.inject.ParamInjectionResolver;
import org.glassfish.jersey.server.spi.internal.ValueFactoryProvider;

/**
 * Resolve PrinterSearchCriteriaParam injection
 *
 * @author TCSCODER
 * @version 1.0
 */
public class PrinterSearchCriteriaParamInjectionResolver extends ParamInjectionResolver<PrinterSearchCriteriaParam> {

    /**
     * {@inheritDoc}
     */
    public PrinterSearchCriteriaParamInjectionResolver(Class<? extends ValueFactoryProvider> valueFactoryProviderClass) {
        super(PrinterSearchCriteriaParamValueFactoryProvider.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMethodParameterIndicator() {
        return true;
    }
}

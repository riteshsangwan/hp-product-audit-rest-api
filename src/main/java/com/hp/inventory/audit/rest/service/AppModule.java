/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.hp.inventory.audit.rest.service.config.ApiConfiguration;
import com.hp.inventory.audit.rest.service.core.Product;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.SessionFactory;

import javax.inject.Named;

/**
 * Guice module for auth application. This class extends from AbstractModule,
 * and overrides the configure method.
 *
 * This class is used to confifure the 'juice' bindings.
 *
 * @author              TCSCODER
 * @version             1.0
 */
public class AppModule extends AbstractModule {

    private final HibernateBundle<Configuration> hibernateBundle = new HibernateBundle<Configuration>(Product.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(Configuration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public AppModule(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    /**
     * Act as a provider for ApiConfiguration instance
     * Wherever in application apiConfiguration is injected by the named binding this instance is returned
     * @param           configuration               Application configuration instance
     * @return                                      ApiConfiguration instance from Application Configuration
     * @since           1.0
     */
    @Provides
    @Named(ApiConfiguration.NAMED_BINDING)
    public ApiConfiguration getApiConfiguration(Configuration configuration) {
        return configuration.getApiConfiguration();
    }

    @Provides
    public SessionFactory provideSessionFactory(Configuration configuration, Environment environment) throws Exception {
        return hibernateBundle.getSessionFactory();
    }

    /**
     * Override the configure method for custom configuration
     * @since           1.0
     */
    @Override
    protected void configure() {

    }
}

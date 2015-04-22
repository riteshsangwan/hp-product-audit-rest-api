package com.assignments.contactsapp;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Copyright 2015
 * Created by anurag on 20/4/15 11:51 PM.
 *
 * @author              anurag
 * @version             1.0
 *
 * Entry point class for auth module.
 * This class has a main method which is invoked by jvm when the jar is started.
 * A typical application run sequence involves
 * 1. initialize the application ( adding any configured bundles, commands etc )
 * 2. After initialization run method is invoked.
 *
 * This application uses guice bundle from hotspot, which adds support for google 'juice' to dropwizard.
 * It automically scans the resources as well as any other provider class.
 */
public class Application extends io.dropwizard.Application<Configuration> {
    /**
     * Default package name to scan. All the packages and classes inside this package will be scanned for auto configuration
     */
    private static final String PACKAGE_SCAN_NAME = "com.assignments";
    private GuiceBundle<Configuration> guiceBundle;
    private AppModule appModule;
    /**
     * Application main entry point method
     * @param           args                        command line arguments
     * @throws          Exception                   If any exception occurs
     * @since           1.0
     */
    public static void main(String[] args) throws Exception {
        new Application().run(args);
    }

    /**
     * Bootstrap the application
     * @param           bootstrap                    dropwizard bootstrap instance
     * @since           1.0
     */
    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        // add the 'juice' bundle
        appModule = new AppModule(bootstrap);
        guiceBundle = GuiceBundle.<Configuration>newBuilder()
                .addModule(appModule)
                .enableAutoConfig(PACKAGE_SCAN_NAME)
                .setConfigClass(com.assignments.contactsapp.Configuration.class)
                .build();
        bootstrap.addBundle(guiceBundle);
        bootstrap.addBundle(new MigrationsBundle<Configuration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(Configuration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    /**
     * run method.
     * @param           configuration                   application configuration
     * @param           environment                     dropwizard environment instance
     * @throws          Exception                       If anything goes wrong
     * @since           1.0
     */
    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        // empty method
    }
}

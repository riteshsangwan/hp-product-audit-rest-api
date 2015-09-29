/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.dao;

import com.google.inject.Inject;
import com.hp.inventory.audit.rest.service.core.Product;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * DAO implementation for Product table
 *
 * @author              TCSCODER
 * @version             1.0
 */
public class ProductDAO extends AbstractDAO<Product> {
    private final SessionFactory sessionFactory;

    @Inject
    public ProductDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }
}

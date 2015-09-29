/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.dao;

import com.google.inject.Inject;
import com.hp.inventory.audit.rest.service.core.SearchCriteria;
import com.hp.inventory.audit.rest.service.core.SearchResultCursor;
import com.hp.inventory.audit.rest.service.core.ServiceResult;
import com.hp.inventory.audit.rest.service.core.SortCriteria;
import com.hp.inventory.audit.rest.service.core.SortOrder;
import com.hp.inventory.audit.rest.service.core.Tablet;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import java.util.List;

/**
 * DAO implementation for Tablet table
 *
 * @author              TCSCODER
 * @version             1.0
 */
public class TabletDAO extends AbstractDAO<Tablet> {

    /**
     * Represents the hibernate session factory
     */
    private final SessionFactory sessionFactory;

    /**
     * Constructor, whenever an instance of this class is created sessionFactory is injected by guice
     * @param sessionFactory the hibernate session factory
     */
    @Inject
    public TabletDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    /**
     * Search the database based on the given search criteria
     * @param criteria the search criteria
     * @return Generic ServiceResult with embedded search results and search result cursor
     */
    public ServiceResult<Tablet> search(SearchCriteria criteria) {
        Session session = this.sessionFactory.openSession();
        Criteria hibernateCriteria = session.createCriteria(Tablet.class);
        if(criteria.getMinCurrentPrice() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.ge("currentPrice", criteria.getMinCurrentPrice()));
        }
        if(criteria.getMaxCurrentPrice() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.le("currentPrice", criteria.getMaxCurrentPrice()));
        }
        if(criteria.getMinParseDate() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.ge("parseDate", criteria.getMinParseDate()));
        }
        if(criteria.getMaxParseDate() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.le("parseDate", criteria.getMaxParseDate()));
        }
        if(criteria.getRating() != null && !criteria.getRating().isEmpty()) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.in("rating", criteria.getRating()));
        }
        // add partial response projections
        if(criteria.getFields() != null && !criteria.getFields().isEmpty()) {
            ProjectionList projectionList = Projections.projectionList();
            for(String field: criteria.getFields()) {
                projectionList = projectionList.add(Projections.property(field), field);
            }
            hibernateCriteria = hibernateCriteria.setProjection(projectionList);
            hibernateCriteria = hibernateCriteria.setResultTransformer(Transformers.aliasToBean(Tablet.class));
        }
        // add sort order
        if(criteria.getSort() != null && !criteria.getSort().isEmpty()) {
            for(SortCriteria sortCriteria: criteria.getSort()) {
                if(sortCriteria.getOrder() == SortOrder.ASCENDING) {
                    hibernateCriteria = hibernateCriteria.addOrder(Order.asc(sortCriteria.getKey()));
                } else if(sortCriteria.getOrder() == SortOrder.DESCENDING) {
                    hibernateCriteria = hibernateCriteria.addOrder(Order.desc(sortCriteria.getKey()));
                }
            }
        }
        // add limit and offset
        int offset = criteria.getOffset() != null ? criteria.getOffset() : 0;
        hibernateCriteria.setFirstResult(offset);
        hibernateCriteria = hibernateCriteria.setMaxResults(criteria.getLimit());

        List<Tablet> result = hibernateCriteria.list();
        // lazy load referenced entities
        if(criteria.getImages() != null && criteria.getImages()) {
            for(Tablet tablet: result) {
                // typical lazy initialize
                tablet.getImages();
            }
        }
        if(criteria.getRa() != null && criteria.getRa()) {
            for(Tablet tablet: result) {
                // typical lazy initialize
                tablet.getTopAccessories();
            }
        }
        long total = (long) session.createCriteria(Tablet.class).setProjection(Projections.rowCount()).uniqueResult();
        long totalPages = total/criteria.getLimit() + 1;
        SearchResultCursor cursor = new SearchResultCursor();
        cursor.setLimit(criteria.getLimit());
        cursor.setOffset(offset);
        cursor.setTotalCount(total);
        cursor.setTotalPages(totalPages);
        session.close();
        return new ServiceResult<Tablet>(result, cursor);
    }

    /**
     * Find an entity by id
     * @param id the id
     * @return the matched entity or null if there is no such entity
     */
    public Tablet findById(String id) {
        Session session = this.sessionFactory.openSession();
        Tablet tablet = (Tablet) session.get(Tablet.class, id);
        session.close();
        return tablet;
    }
}

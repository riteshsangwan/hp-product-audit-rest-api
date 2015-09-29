/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.dao;

import com.google.inject.Inject;
import com.hp.inventory.audit.rest.service.core.Printer;
import com.hp.inventory.audit.rest.service.core.PrinterSearchCriteria;
import com.hp.inventory.audit.rest.service.core.SearchResultCursor;
import com.hp.inventory.audit.rest.service.core.ServiceResult;
import com.hp.inventory.audit.rest.service.core.SortCriteria;
import com.hp.inventory.audit.rest.service.core.SortOrder;
import io.dropwizard.hibernate.AbstractDAO;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import java.util.List;

/**
 * DAO implementation for Printer table
 *
 * @author TCSCODER
 * @version 1.0
 */
public class PrinterDAO extends AbstractDAO<Printer> {
    private final SessionFactory sessionFactory;

    @Inject
    public PrinterDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public ServiceResult<Printer> search(PrinterSearchCriteria criteria) {
        Session session = this.sessionFactory.openSession();
        Criteria hibernateCriteria = session.createCriteria(Printer.class);
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
        if(StringUtils.isNotBlank(criteria.getType())) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.like("type", criteria.getType(), MatchMode.ANYWHERE));
        }
        // add partial response projections
        if(criteria.getFields() != null && !criteria.getFields().isEmpty()) {
            ProjectionList projectionList = Projections.projectionList();
            for(String field: criteria.getFields()) {
                projectionList = projectionList.add(Projections.property(field), field);
            }
            hibernateCriteria = hibernateCriteria.setProjection(projectionList);
            hibernateCriteria = hibernateCriteria.setResultTransformer(Transformers.aliasToBean(Printer.class));
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

        List<Printer> result = hibernateCriteria.list();
        // lazy load referenced entities
        if(criteria.getImages() != null && criteria.getImages()) {
            for(Printer printer: result) {
                // typical lazy initialize
                printer.getImages().size();
            }
        }
        if(criteria.getRa() != null && criteria.getRa()) {
            for(Printer printer: result) {
                // typical lazy initialize
                printer.getTopAccessories().size();
            }
        }
        long total = (long) session.createCriteria(Printer.class).setProjection(Projections.rowCount()).uniqueResult();
        long totalPages = total/criteria.getLimit() + 1;
        SearchResultCursor cursor = new SearchResultCursor();
        cursor.setLimit(criteria.getLimit());
        cursor.setOffset(offset);
        cursor.setTotalCount(total);
        cursor.setTotalPages(totalPages);
        session.close();
        return new ServiceResult<Printer>(result, cursor);
    }

    public Printer findById(String id) {
        Session session = this.sessionFactory.openSession();
        return (Printer) session.get(Printer.class, id);
    }
}

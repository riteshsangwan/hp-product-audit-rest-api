/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.dao;

import com.google.inject.Inject;
import com.hp.inventory.audit.rest.service.core.Product;
import com.hp.inventory.audit.rest.service.core.ProductImage;
import com.hp.inventory.audit.rest.service.core.ProductSearchCriteria;
import com.hp.inventory.audit.rest.service.core.RelatedAccessory;
import com.hp.inventory.audit.rest.service.core.SearchResultCursor;
import com.hp.inventory.audit.rest.service.core.ServiceResult;
import com.hp.inventory.audit.rest.service.core.SortCriteria;
import com.hp.inventory.audit.rest.service.core.SortOrder;
import com.hp.inventory.audit.rest.service.exceptions.EntityNotFoundException;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import java.util.Collection;
import java.util.List;

/**
 * DAO implementation for Product table
 *
 * @author              TCSCODER
 * @version             1.0
 */
public class ProductDAO extends AbstractDAO<Product> {

    /**
     * Represents the hibernate session factory
     */
    private final SessionFactory sessionFactory;

    /**
     * Constructor, whenever an instance of this class is created sessionFactory is injected by guice
     * @param sessionFactory the hibernate session factory
     */
    @Inject
    public ProductDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    /**
     * Search the database based on the given search criteria
     * @param criteria the search criteria
     * @return Generic ServiceResult with embedded search results and search result cursor
     */
    public ServiceResult<Product> search(ProductSearchCriteria criteria) {
        Session session = this.sessionFactory.openSession();
        Criteria hibernateCriteria = session.createCriteria(Product.class);

        // search filtering
        if(criteria.getMinCurrentPrice() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.ge("currentPrice", criteria.getMinCurrentPrice()));
        }
        if(criteria.getMaxCurrentPrice() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.le("currentPrice", criteria.getMaxCurrentPrice()));
        }

        if(criteria.getRating() != null && !criteria.getRating().isEmpty()) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.in("rating", criteria.getRating()));
        }
        if(criteria.getProductType() != null && !criteria.getProductType().isEmpty()) {
            for(String type: criteria.getProductType()) {
                hibernateCriteria = hibernateCriteria.add(Restrictions.or(Restrictions.like("productType", type, MatchMode.ANYWHERE)));
            }
        }
        // audit timestamp
        if(criteria.getMinAuditTimestamp() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.ge("auditTimestamp", criteria.getMinAuditTimestamp()));
        }
        if(criteria.getMaxAuditTimestamp() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.le("auditTimestamp", criteria.getMaxAuditTimestamp()));
        }

        // date added
        if(criteria.getMinDateAdded() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.ge("dateAdded", criteria.getMinDateAdded()));
        }
        if(criteria.getMaxDateAdded() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.le("dateAdded", criteria.getMaxDateAdded()));
        }

        if(criteria.getPreviousPrice() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.eq("previousPrice", criteria.getPreviousPrice()));
        }

        // date of price change
        if(criteria.getMinDateOfPriceChange() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.ge("dateOfPriceChange", criteria.getMinDateOfPriceChange()));
        }
        if(criteria.getMaxDateOfPriceChange() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.le("dateOfPriceChange", criteria.getMaxDateOfPriceChange()));
        }

        if(criteria.getPreviousRating() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.eq("previousRating", criteria.getPreviousRating()));
        }

        // date of rating change
        if(criteria.getMinDateOfRatingChange() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.ge("dateOfRatingChange", criteria.getMinDateOfRatingChange()));
        }
        if(criteria.getMaxDateOfRatingChange() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.le("dateOfRatingChange", criteria.getMaxDateOfRatingChange()));
        }

        // date of parsing error
        if(criteria.getMinDateOfParsingError() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.ge("dateOfParsingError", criteria.getMinDateOfParsingError()));
        }
        if(criteria.getMaxDateOfParsingError() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.le("dateOfParsingError", criteria.getMaxDateOfParsingError()));
        }

        // coming soon date
        if(criteria.getMinComingSoonDate() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.ge("comingSoonDate", criteria.getMinComingSoonDate()));
        }
        if(criteria.getMaxComingSoonDate() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.le("comingSoonDate", criteria.getMaxComingSoonDate()));
        }

        // available for sale date
        if(criteria.getMinAvailableForSaleDate() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.ge("availableForSaleDate", criteria.getMinAvailableForSaleDate()));
        }
        if(criteria.getMaxAvailableForSaleDate() != null) {
            hibernateCriteria = hibernateCriteria.add(Restrictions.le("availableForSaleDate", criteria.getMaxAvailableForSaleDate()));
        }

        // add partial response projections
        if(criteria.getFields() != null && !criteria.getFields().isEmpty()) {
            ProjectionList projectionList = Projections.projectionList();
            for(String field: criteria.getFields()) {
                projectionList = projectionList.add(Projections.property(field), field);
            }
            hibernateCriteria = hibernateCriteria.setProjection(projectionList);
            hibernateCriteria = hibernateCriteria.setResultTransformer(Transformers.aliasToBean(Product.class));
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

        List<Product> result = hibernateCriteria.list();


        // lazy load referenced entities
        if(criteria.getImages() != null && criteria.getImages()) {
            for(Product product: result) {
                // typical lazy initialize
                product.getImages().size();
            }
        }
        if(criteria.getRa() != null && criteria.getRa()) {
            for(Product product: result) {
                // typical lazy initialize
                product.getTopAccessories().size();
            }
        }

        // pagination
        long total = (long) session.createCriteria(Product.class).setProjection(Projections.rowCount()).uniqueResult();
        long totalPages = total/criteria.getLimit() + 1;
        SearchResultCursor cursor = new SearchResultCursor();
        cursor.setLimit(criteria.getLimit());
        cursor.setOffset(offset);
        cursor.setTotalCount(total);
        cursor.setTotalPages(totalPages);
        session.close();
        return new ServiceResult<Product>(result, cursor);
    }

    /**
     * Find an entity by id
     * @param id the id
     * @return the matched entity or null if there is no such entity
     */
    public Product findById(String id) {
        Session session = this.sessionFactory.openSession();
        Product product = (Product) session.get(Product.class, id);
        session.close();
        return product;
    }

    /**
     * Get referenced product images
     * @param id the product id to get the images for
     * @return a list of ProductImage
     */
    public Collection<ProductImage> getProductImages(String id) throws EntityNotFoundException {
        Session session = sessionFactory.openSession();
        Product product = (Product) session.get(Product.class, id);
        if(product == null) {
            throw new EntityNotFoundException("Product not found with the given product number");
        }
        // typical lazy initialization
        product.getImages().size();
        return product.getImages();
    }

    /**
     * Get referenced accessories
     * @param id the product id to get the images for
     * @return a list of ProductImage
     */
    public Collection<RelatedAccessory> getProductAccessories(String id) throws EntityNotFoundException {
        Session session = sessionFactory.openSession();
        Product product = (Product) session.get(Product.class, id);
        if(product == null) {
            throw new EntityNotFoundException("Product not found with the given product number");
        }
        // typical lazy initialization
        product.getTopAccessories().size();
        return product.getTopAccessories();
    }
}

package com.assignments.contactsapp.dao;

import com.assignments.contactsapp.core.User;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Copyright 2015
 * Created by anurag on 21/04/15.
 *
 * @author              anurag
 * @version             1.0
 */
public class UserDAO extends AbstractDAO<User> {
    private final SessionFactory sessionFactory;
    @Inject
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public Optional<User> findById(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        transaction.commit();
        session.close();
        return Optional.fromNullable(user);
    }

    public Optional<User> findByEmail(String email) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedQuery("com.assignments.contactsapp.core.User.findByEmail");
        query.setString("email", email);
        User user = (User) query.list().get(0);
        transaction.commit();
        session.close();
        return Optional.fromNullable(user);
    }

    public User create(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Long id = (Long) session.save(user);
        user.setId(id);
        transaction.commit();
        session.close();
        return user;
    }

    public User update(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User updatedUser = (User) session.merge(user);
        transaction.commit();
        session.close();
        return updatedUser;
    }

    public void delete(long userId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(User.class, userId);
        session.delete(user);
        session.close();
        transaction.commit();
    }

    public List<User> findAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedQuery("com.assignments.contactsapp.core.User.findByEmail");
        session.close();
        return (List<User>) query.list();
    }
}

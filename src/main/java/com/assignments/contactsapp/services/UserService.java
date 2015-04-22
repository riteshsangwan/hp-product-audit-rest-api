package com.assignments.contactsapp.services;

import com.assignments.contactsapp.Configuration;
import com.assignments.contactsapp.config.ApiConfiguration;
import com.assignments.contactsapp.core.Constants;
import com.assignments.contactsapp.core.LoginResult;
import com.assignments.contactsapp.core.ServiceResult;
import com.assignments.contactsapp.core.User;
import com.assignments.contactsapp.dao.UserDAO;
import com.assignments.contactsapp.exceptions.ApiException;
import com.assignments.contactsapp.exceptions.ErrorCodes;
import com.assignments.contactsapp.util.Cryptography;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.validation.Validated;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.Instant;

import javax.inject.Named;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2015
 * Created by anurag on 21/04/15 01:27 AM
 */
@Singleton
public class UserService {

    private final UserDAO userDAO;
    private final Configuration configuration;
    private final ApiConfiguration apiConfiguration;

    /**
     * Default constructor. Whenever an instance of this class is created 'juice' will make sure that all the dependencies are properly injected
     * @param   userDAO                                 DAO implementation for this service
     * @param   configuration                           Application configuration instance
     * @param   apiConfiguration                        commons api configuration instance
     * @since   1.0
     */
    @Inject
    public UserService(UserDAO userDAO, @Validated Configuration configuration, @Validated @Named(ApiConfiguration.NAMED_BINDING) ApiConfiguration apiConfiguration) {
        this.userDAO = userDAO;
        this.apiConfiguration = apiConfiguration;
        this.configuration = configuration;
    }

    public ServiceResult<LoginResult> login(User credentials) throws ApiException {
        Optional<User> existing = userDAO.findByEmail(credentials.getEmail());
        if(existing.isPresent()) {
            User user = existing.get();
            boolean isValid = Cryptography.validatePassword(credentials.getPassword(), user.getPassword());
            if(isValid) {
                // generate new jwt token
                Map<String, Object> claims = new HashMap<String, Object>();
                claims.put(Constants.USER_ID_IDENTIFIER, user.getId());
                long expiry = new Instant().getMillis() + configuration.getTokenExpirationInMillis();
                claims.put(Constants.TOKEN_EXPIRATION_IDENTIFIER, expiry);
                LoginResult result = new LoginResult(Cryptography.signJWT(claims, apiConfiguration.getJwtSecret()));
                List<LoginResult> results = new ArrayList<LoginResult>();
                results.add(result);
                return new ServiceResult<LoginResult>(results);
            } else {
                throw new ApiException(Response.Status.UNAUTHORIZED, new IllegalArgumentException("Invalid password")).addError(ErrorCodes.INVALID_EMAIL_PASSWORD);
            }
        } else {
            throw new ApiException(Response.Status.NOT_FOUND, new IllegalArgumentException("User not found with given email id")).addError(ErrorCodes.RESOURCE_NOT_FOUND);
        }
    }

    public ServiceResult<User> getMe(long userId) throws ApiException {
        List<User> result = new ArrayList<User>();
        result.add(userDAO.findById(userId).get());
        return new ServiceResult<>(result);
    }

    public ServiceResult<User> register(User entity) throws ApiException {
        entity.setPassword(Cryptography.hashPassword(entity.getPassword()));
        User user = userDAO.create(entity);
        // don't return password
        user.setPassword(null);
        List<User> result = new ArrayList<User>();
        result.add(user);
        return new ServiceResult<User>(result);
    }

    public ServiceResult<User> getAllContacts(long userId) throws ApiException {
        Optional<User> existing = userDAO.findById(userId);
        if(existing.isPresent()) {
            User user = existing.get();
            String contactList = user.getContactList();
            List<User> result = new ArrayList<User>();
            String[] contacts = contactList.split(",");
            for(String contactId: contacts) {
                if(contactId.length() > 0) {
                    User contact = userDAO.findById(Long.valueOf(contactId)).get();
                    // don't return password
                    contact.setPassword(null);
                    result.add(contact);
                }
            }
            return new ServiceResult<User>(result);
        } else {
            throw new ApiException(Response.Status.NOT_FOUND, new IllegalArgumentException("User not found with given id")).addError(ErrorCodes.RESOURCE_NOT_FOUND);
        }
    }

    public ServiceResult<User> updateContact(long userId, long contactId, User contact) throws ApiException {
        Optional<User> existingUser = userDAO.findById(userId);
        if(existingUser.isPresent()) {
            User user = existingUser.get();
            String contactsList = user.getContactList();
            if(contactsList.indexOf(String.valueOf(contactId)) == -1) {
                // contact not exist for given user
                throw new ApiException(Response.Status.NOT_FOUND, new IllegalArgumentException("User don't have the contact with given id")).addError(ErrorCodes.NOT_A_CONTACT);
            } else {
                User existingContact = userDAO.findById(contactId).get();
                User mergedContact = existingContact.merge(contact);
                User updatedContact = userDAO.update(mergedContact);
                updatedContact.setPassword(null);
                List<User> result = new ArrayList<User>();
                result.add(updatedContact);
                return new ServiceResult<User>(result);
            }
        } else {
            throw new ApiException(Response.Status.NOT_FOUND, new IllegalArgumentException("User not found with given id")).addError(ErrorCodes.RESOURCE_NOT_FOUND);
        }
    }
    public void deleteContact(long userId, long contactId) throws ApiException {
        Optional<User> existing = userDAO.findById(userId);
        if(existing.isPresent()) {
            User existingUser = existing.get();
            String contactsList = existingUser.getContactList();
            if(contactsList.indexOf(String.valueOf(contactId)) == -1) {
                throw new ApiException(Response.Status.NOT_FOUND, new IllegalArgumentException("Contact id is not in users contact list")).addError(ErrorCodes.NOT_A_CONTACT);
            }
            List<String> contactIds = new ArrayList<>(Arrays.asList(contactsList.split(",")));
            int index = contactIds.indexOf(String.valueOf(contactId));
            contactIds.remove(index);
            contactsList = StringUtils.join(contactIds, ",");
            existingUser.setContactList(contactsList);
            userDAO.update(existingUser);
        } else {
            throw new ApiException(Response.Status.NOT_FOUND, new IllegalArgumentException("User not found with given id")).addError(ErrorCodes.RESOURCE_NOT_FOUND);
        }
    }

    public ServiceResult<User> addContact(long userId, User contact) throws ApiException {
        Optional<User> existing = userDAO.findById(userId);
        if(existing.isPresent()) {
            User existingUser = existing.get();
            List<String> contactIds = new ArrayList<>(Arrays.asList(existingUser.getContactList().split(",")));
            User addedContact = userDAO.create(contact);
            contactIds.add(String.valueOf(addedContact.getId()));
            String contactsList = StringUtils.join(contactIds, ",");
            existingUser.setContactList(contactsList);
            List<User> result = new ArrayList<User>();
            User updated = userDAO.update(existingUser);
            updated.setPassword(null);
            result.add(updated);
            return new ServiceResult<User>(result);
        } else {
            throw new ApiException(Response.Status.NOT_FOUND, new IllegalArgumentException("User not found with given id")).addError(ErrorCodes.RESOURCE_NOT_FOUND);
        }
    }


}

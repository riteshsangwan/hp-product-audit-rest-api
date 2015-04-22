package com.assignments.contactsapp.resources;

import com.assignments.contactsapp.annotations.AuthParam;
import com.assignments.contactsapp.core.ApiResponse;
import com.assignments.contactsapp.core.AuthToken;
import com.assignments.contactsapp.core.LoginResult;
import com.assignments.contactsapp.core.Payload;
import com.assignments.contactsapp.core.ServiceResult;
import com.assignments.contactsapp.core.User;
import com.assignments.contactsapp.exceptions.ApiException;
import com.assignments.contactsapp.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Copyright 2015
 * Created by anurag on 20/4/15 10:42 PM.
 *
 * @author              anurag
 * @version             1.0
 *
 * jersey resource class for users endpoint
 * This class exposes ENDPOINTS corresponding to actions performed on to a users resource in the application
 * Only the application/json MIME type is supported.
 */
@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
public class Users {

    private final UserService service;

    /**
     * Default public constructor. Whenever an instance of this class is created, singleton instance of UserService is injected by guice.
     * @param   service                 UserService singleton instance
     * @since   1.0
     */
    @Inject
    public Users(UserService service) {
        this.service = service;
    }

    /**
     * Handles login for a user
     * @param   user                    user instance to validate
     * @return                          Generic ApiResponse instance which wraps the generated jwt token
     * @throws  ApiException            If any exception occurs
     */
    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse login(User user) throws ApiException {
        ServiceResult<LoginResult> result = this.service.login(user);
        return ApiResponse.buildWithPayload(new Payload<LoginResult>().addObjects(result.getResult())).setStatus(Response.Status.OK);
    }

    /**
     * Handles registration for a user
     * @param   user                    user instance to validate
     * @return                          Generic ApiResponse instance which wraps the registered user
     * @throws  ApiException            If any exception occurs
     */
    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse register(User user) throws ApiException {
        ServiceResult<User> result = this.service.register(user);
        return ApiResponse.buildWithPayload(new Payload<User>().addObjects(result.getResult())).setStatus(Response.Status.CREATED);
    }

    /**
     * Get a list of all contacts for a particular user
     * @param   authToken               Authentication context associated with this request
     * @return                          Generic ApiResponse instance which wraps a list of all contacts
     * @throws  ApiException            If any exception occurs
     */
    @Path("/users/me/contacts")
    @GET
    public ApiResponse getAllContacts(@AuthParam AuthToken authToken) throws ApiException {
        ServiceResult<User> result = this.service.getAllContacts(authToken.getUserId());
        return ApiResponse.buildWithPayload(new Payload<User>().addObjects(result.getResult())).setStatus(Response.Status.OK);
    }

    /**
     * Get current user information
     * @param   authToken               Authentication context associated with this request
     * @return                          Generic ApiResponse instance which wraps a list of all contacts
     * @throws  ApiException            If any exception occurs
     */
    @Path("/users/me")
    @GET
    public ApiResponse getMe(@AuthParam AuthToken authToken) throws ApiException {
        ServiceResult<User> result = this.service.getMe(authToken.getUserId());
        return ApiResponse.buildWithPayload(new Payload<User>().addObjects(result.getResult())).setStatus(Response.Status.OK);
    }

    /**
     * Edit a contact for a user
     * @param   authToken               Authentication context associated with this request
     * @param   contactId               contactId to edit
     * @param   user                    entity to update
     * @return                          Generic ApiResponse instance which wraps the updated contact
     * @throws  ApiException            If any exception occurs
     */
    @Path("/users/me/contacts/{contactId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse updateContact(@AuthParam AuthToken authToken, @PathParam("contactId") long contactId, User user) throws ApiException {
        ServiceResult<User> result = this.service.updateContact(authToken.getUserId(), contactId, user);
        return ApiResponse.buildWithPayload(new Payload<User>().addObjects(result.getResult())).setStatus(Response.Status.OK);
    }

    /**
     * Delete a contact for a user
     * @param   authToken               Authentication context associated with this request
     * @param   contactId               contactId to delete
     * @return                          Generic ApiResponse instance with 204 status code
     * @throws  ApiException            If any exception occurs
     */
    @Path("/users/me/contacts/{contactId}")
    @DELETE
    public ApiResponse deleteContact(@AuthParam AuthToken authToken, @PathParam("contactId") long contactId, User user) throws ApiException {
        this.service.deleteContact(authToken.getUserId(), contactId);
        return ApiResponse.build().setStatus(Response.Status.NO_CONTENT);
    }

    /**
     * Add a contact to a user
     * @param   authToken               Authentication context associated with this request
     * @param   user                    entity to add
     * @return                          Generic ApiResponse instance with 204 status code
     * @throws  ApiException            If any exception occurs
     */
    @Path("/users/me/contacts")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse addContact(@AuthParam AuthToken authToken, User user) throws ApiException {
        this.service.addContact(authToken.getUserId(), user);
        return ApiResponse.build().setStatus(Response.Status.OK);
    }

}

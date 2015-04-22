package com.assignments.contactsapp.factories;

import com.assignments.contactsapp.config.ApiConfiguration;
import com.assignments.contactsapp.core.AuthToken;
import com.assignments.contactsapp.core.Constants;
import com.assignments.contactsapp.core.TokenSchemes;
import com.assignments.contactsapp.exceptions.ApiException;
import com.assignments.contactsapp.exceptions.ErrorCodes;
import com.assignments.contactsapp.util.Cryptography;
import com.google.common.base.Objects;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;
import org.joda.time.Instant;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Copyright 2015
 * Created by anurag on 22/4/15 03:21 AM.
 *
 * @author anurag
 */
@Singleton
public class AuthTokenValueFactory extends AbstractContainerRequestValueFactory<AuthToken> {

    @Inject
    private HttpServletRequest request;
    @Inject
    @Named(ApiConfiguration.NAMED_BINDING)
    private ApiConfiguration apiConfiguration;

    @Override
    public AuthToken provide() throws ApiException {
        // prase the request and construct AuthToken instance
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(authHeader == null || authHeader.length() < 1) {
            throw new ApiException(Response.Status.UNAUTHORIZED, new IllegalArgumentException("Invalid token. Token should be present")).addError(ErrorCodes.INVALID_AUTHORIZATION_TOKEN);
        }
        String[] splitted = authHeader.split(" ");
        if(splitted.length != 2 || !splitted[0].equals(TokenSchemes.BEARER.getScheme()) || splitted[1].length() < 1) {
            // malformed http header
            throw new ApiException(Response.Status.UNAUTHORIZED, new IllegalArgumentException("Invalid token. Token should be of form [Bearer <Token>]")).addError(ErrorCodes.INVALID_AUTHORIZATION_TOKEN);
        }
        Map<String, Object> decodedPayload = Cryptography.decodeJwtToken(splitted[1], apiConfiguration.getJwtSecret(), apiConfiguration.getJwtAudience());
        // check the token expiry date
        if(Objects.equal(null, decodedPayload.get(Constants.TOKEN_EXPIRATION_IDENTIFIER))) {
            throw new ApiException(Response.Status.UNAUTHORIZED, new IllegalArgumentException("Expiration date should be encoded in jwt token")).addError(ErrorCodes.INVALID_AUTHORIZATION_TOKEN);
        }
        long millis = Long.valueOf(decodedPayload.get(Constants.TOKEN_EXPIRATION_IDENTIFIER).toString());
        if(millis <= new Instant().getMillis()) {
            throw new ApiException(Response.Status.UNAUTHORIZED, new IllegalArgumentException("JWT token expired")).addError(ErrorCodes.JWT_TOKEN_EXPIRED);
        }
        if(Objects.equal(null, decodedPayload.get(Constants.USER_ID_IDENTIFIER))) {
            throw new ApiException(Response.Status.UNAUTHORIZED, new IllegalArgumentException(Constants.USER_ID_IDENTIFIER + " should be encoded in jwt token")).addError(ErrorCodes.INVALID_AUTHORIZATION_TOKEN);
        }
        long userId = Long.valueOf(decodedPayload.get(Constants.USER_ID_IDENTIFIER).toString());
        return new AuthToken(userId);
    }
}
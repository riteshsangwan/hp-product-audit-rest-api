package com.assignments.contactsapp.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Copyright 2015
 * Created by anurag on 20/4/15 1:10 PM.
 *
 * @author              anurag
 * @version             1.0
 *
 * Enum for all the error codes in the application.
 * Any error that belongs to 4xx or 5xx category in HTTP RESPONSE belongs one of these error conditions
 * This enum class will be serialized into json using jackson as any other pojo class.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCodes {
    MANDATORY_FIELD_MISSING(400001, "One of the mandatory field is missing"),

    UNAUTHORIZED(401001, "User is not authorized"),
    JWT_TOKEN_EXPIRED(401002, "JWT token expired, kindly refresh token by login again"),
    INVALID_AUTHORIZATION_TOKEN(401003, "Invalid authorization token"),
    INVALID_VERIFICATION_TOKEN(401004, "Invalid Verification token"),
    INVALID_EMAIL_PASSWORD(401005, "Invalid password"),
    EMAIL_ALREADY_EXIST(400001, "Email address already exists"),
    INTERNAL_SERVER_ERROR(500001, "Internal server error occurred while processing your request"),
    NOT_A_CONTACT(400002, "User don't have a contact with given contact id"),
    ALREADY_A_CONTACT(400003, "User already has a contact with given id"),

    RESOURCE_NOT_FOUND(404001, "Requested resource not found");

    private int code;
    private String message;

    /**
     * Constructor
     * @param   code                    error code
     * @param   message                 error message
     * @since   1.0
     */
    ErrorCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Get the error code for this enum value
     * @return                          error code
     * @since   1.0
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Get the error message for this enum value
     * @return                          error message
     * @since   1.0
     */
    public String getMessage() {
        return this.message;
    }
}

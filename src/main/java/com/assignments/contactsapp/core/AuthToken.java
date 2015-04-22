package com.assignments.contactsapp.core;

/**
 * Created by anurag on 22/04/15.
 */
public class AuthToken {

    private final Long userId;

    public AuthToken(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}

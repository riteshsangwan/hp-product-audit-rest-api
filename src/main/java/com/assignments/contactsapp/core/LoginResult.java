package com.assignments.contactsapp.core;

import java.io.Serializable;

/**
 * Created by anurag on 21/04/15.
 */
public class LoginResult implements Serializable {

    private final String token;

    public LoginResult(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}

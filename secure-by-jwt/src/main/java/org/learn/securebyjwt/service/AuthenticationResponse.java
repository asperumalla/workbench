package org.learn.securebyjwt.service;

public class AuthenticationResponse {
    // we need a contructor as this is final, we need to provide the
    // intialization
    private final String jwt;

    public AuthenticationResponse (String jwt) {
        this.jwt = jwt;
    }

    public String getJwt () {
        return jwt;
    }
}

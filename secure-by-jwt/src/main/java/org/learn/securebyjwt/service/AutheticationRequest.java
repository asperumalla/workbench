package org.learn.securebyjwt.service;

public class AutheticationRequest {

    private String username;
    private String password;

    public AutheticationRequest (String username, String password) {
        this.username = username;
        this.password = password;
    }

    // We need this for serialization
    public AutheticationRequest () {
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }
}

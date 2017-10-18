package com.AppointmentSystem.requestDto;

/**
 * Created by Ruzal on 9/18/2017.
 */

public class LoginRequest {

    private long id;
    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

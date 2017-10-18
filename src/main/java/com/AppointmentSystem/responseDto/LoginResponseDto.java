package com.AppointmentSystem.responseDto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by Ruzal on 9/17/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponseDto implements Serializable {
    private long id;
    private String token;

    public LoginResponseDto(long id, String token) {
        this.id = id;
        this.token = token;
    }

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

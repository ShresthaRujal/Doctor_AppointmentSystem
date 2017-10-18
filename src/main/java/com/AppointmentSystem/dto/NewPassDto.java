package com.AppointmentSystem.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Ruzal on 9/5/2017.
 */
public class NewPassDto {
    @NotEmpty(message = "Enter your new password.")
    @Length(min = 8,message = "Password is too short")
    private String password;
    @NotEmpty
    @Length(min = 8,message = "Password is too short")
    private String passwordagain;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordagain() {
        return passwordagain;
    }

    public void setPasswordagain(String passwordagain) {
        this.passwordagain = passwordagain;
    }
}

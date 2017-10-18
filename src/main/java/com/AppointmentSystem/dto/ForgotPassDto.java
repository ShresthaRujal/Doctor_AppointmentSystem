package com.AppointmentSystem.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Ruzal on 9/4/2017.
 */
public class ForgotPassDto {

    @Email(message = "Enter your email.")
    @NotEmpty(message = "Email is not valid.")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.AppointmentSystem.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Ruzal on 9/2/2017.
 */
public class PatientLoginDto {

    @NotEmpty(message = "Enter Email!")
    @Email(message = "Invalid Email!!")
    private String email;
    @Length(min = 8, message = "Password length must be at least 8!")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

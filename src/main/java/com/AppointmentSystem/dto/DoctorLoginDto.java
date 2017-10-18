package com.AppointmentSystem.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Ruzal on 9/4/2017.
 */
public class DoctorLoginDto {

    private long id;

    @Length(min = 8,message = "Password must be atleast of 8 Character!")
    @NotEmpty(message = "Enter your password.")
    private String pass;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

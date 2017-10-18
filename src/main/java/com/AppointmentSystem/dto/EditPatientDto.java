package com.AppointmentSystem.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Ruzal on 9/7/2017.
 */
public class EditPatientDto {
    private long id;
    @NotEmpty(message = "Enter you name.")
    private String name;
    @Email
    @NotEmpty(message = "Email should not be blank")
    private String email;
    @NotEmpty(message = "Enter Email")
    private String address;
    @Length(min = 10,max = 10,message = "Your Phone no is not valid!")
    private String contact;
    @NotEmpty(message = "Select your Date of Birth.")
    private String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

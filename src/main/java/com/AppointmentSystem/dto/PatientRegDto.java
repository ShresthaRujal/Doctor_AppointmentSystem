package com.AppointmentSystem.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Ruzal on 9/3/2017.
 */
public class PatientRegDto {
    @NotEmpty(message = "Enter your name!")
    private String name;
    @NotEmpty(message = "Enter your password!")
    @Length(min = 8,message = "Password must me at least of 8 character.")
    private String password;

    @NotEmpty(message = "Enter your Email!")
    @Email
    private String email;

    private String sex;

    @NotEmpty(message = "Select your Date of Birth.")
    private String date;
    @NotEmpty(message = "Contact is Null.")

    @Length(min = 10,max = 10,message = "Your Phone no. is not valid!")
    private String contact;

    @NotEmpty(message = "Address is Null.")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

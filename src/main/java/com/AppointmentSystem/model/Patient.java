package com.AppointmentSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "contact")
    private String contact;
    @Column(name = "address")
    private String address;
    @Column(name = "sex")
    private String sex;

    @Column(name = "date")
    private String date;
    @JsonIgnore
    @Column(name = "password")
    private String password;
    @Column(name="pp")
    private String pp;

    private String token;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private  Document document;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", date='" + date + '\'' +
                ", password='" + password + '\'' +
                ", pp='" + pp + '\'' +
                ", token='" + token + '\'' +
                ", document=" + document +
                '}';
    }
}

package com.AppointmentSystem.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "Specify Department name.")
    private String department;
    @NotEmpty
    private String doctor;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String sex;
    @NotEmpty(message = "Select appointment date")
    private String date;

    private long time;
    private long timeMM;
    private long patient_id;
    private String details;
    private Date now;
    private String document;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTimeMM() {
        return timeMM;
    }

    public void setTimeMM(long timeMM) {
        this.timeMM = timeMM;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(long patient_id) {
        this.patient_id = patient_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", doctor='" + doctor + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", date='" + date + '\'' +
                ", time=" + time +
                ", timeMM=" + timeMM +
                ", patient_id=" + patient_id +
                ", details='" + details + '\'' +
                ", now=" + now +
                ", document='" + document + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
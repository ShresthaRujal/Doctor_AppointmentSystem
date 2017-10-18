package com.AppointmentSystem.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by Ruzal on 8/24/2017.
 */
@Entity
@Table(name = "document")
public class Document {
    @Id
    private Long id;
    private String docuemnt;

    public Document() {
    }

    public Document(Long id, String docuemnt) {
        this.id = id;
        this.docuemnt = docuemnt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocuemnt() {
        return docuemnt;
    }

    public void setDocuemnt(String docuemnt) {
        this.docuemnt = docuemnt;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", docuemnt='" + docuemnt + '\'' +
                '}';
    }
}

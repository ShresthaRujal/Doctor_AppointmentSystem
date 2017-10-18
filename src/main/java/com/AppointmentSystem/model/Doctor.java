package com.AppointmentSystem.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Entity
@Table(name = "Doctor")
public class Doctor implements Serializable {
    @Id
    @Min(2)
    private long Did;
    @Column(name = "dname")
    private String Dname;
    @Column(name = "dtype")
    private String Dtype;
    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "dpass")
    private String Dpass;
    @Column(name = "dphone")
    private String Dphone;
    @Column(name = "pp")
    private String pp;

    public Doctor() {
    }

    public Doctor(long did, String dname, String dtype, String dpass, String dphone, String pp) {
        Did = did;
        Dname = dname;
        Dtype = dtype;
        Dpass = dpass;
        Dphone = dphone;
        this.pp = pp;
    }

    public long getDid() {
        return Did;
    }

    public void setDid(long did) {
        Did = did;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getDtype() {
        return Dtype;
    }

    public void setDtype(String dtype) {
        Dtype = dtype;
    }

    public String getDpass() {
        return Dpass;
    }

    public void setDpass(String dpass) {
        Dpass = dpass;
    }

    public String getDphone() {
        return Dphone;
    }

    public void setDphone(String dphone) {
        Dphone = dphone;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Did=" + Did +
                ", Dname='" + Dname + '\'' +
                ", Dtype='" + Dtype + '\'' +
                ", Dpass='" + Dpass + '\'' +
                ", Dphone='" + Dphone + '\'' +
                ", pp='" + pp + '\'' +
                '}';
    }
}

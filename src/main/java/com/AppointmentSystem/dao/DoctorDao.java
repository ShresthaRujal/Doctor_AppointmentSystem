package com.AppointmentSystem.dao;

import com.AppointmentSystem.model.Doctor;

import javax.print.Doc;
import java.util.List;

/**
 * Created by Ruzal on 8/23/2017.
 */
public interface DoctorDao {
    void insert(Doctor doctor);
    void delete(Doctor doctor);
    List<Doctor> doctors();
    void update(Doctor doctor);

    Doctor getDoctor(Doctor doctor);

    List<Doctor> getDoctorByType();

    Doctor getDoctorById(long id);
}

package com.AppointmentSystem.service;

import com.AppointmentSystem.model.Doctor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ruzal on 8/23/2017.
 */
public interface DoctorService {
    void insert(Doctor doctor);
    void delete(Doctor doctor);
    List<Doctor> doctors();
    void update(Doctor doctor);

    Doctor getDoctor(Doctor doctor);

    List<Doctor> getDoctorByType();

    Doctor getDoctorById(long id);
    List<Doctor> getAllDoctor();
}

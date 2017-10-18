package com.AppointmentSystem.dao;

import com.AppointmentSystem.dto.PatientLoginDto;
import com.AppointmentSystem.dto.PatientRegDto;
import com.AppointmentSystem.model.Doctor;
import com.AppointmentSystem.model.Patient;

import java.util.List;

/**
 * Created by Ruzal on 8/23/2017.
 */
public interface PatientDao {
    Boolean insert(Patient patient);
    List<Patient> findAll();
    Patient selectByEmail(Patient patient);
    Patient selectById(long id);

    Boolean check(Patient patient);

    Patient selectByEmailOnly(PatientLoginDto patientLoginDto);

    void changePass(Patient patient);

    void editPatient(Patient patient);
}

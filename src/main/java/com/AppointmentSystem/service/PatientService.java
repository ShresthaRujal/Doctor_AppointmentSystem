package com.AppointmentSystem.service;

import com.AppointmentSystem.dto.EditPatientDto;
import com.AppointmentSystem.dto.PatientLoginDto;
import com.AppointmentSystem.dto.PatientRegDto;
import com.AppointmentSystem.model.Patient;

/**
 * Created by Ruzal on 8/23/2017.
 */
public interface PatientService {
    Boolean insert(PatientRegDto patientRegDto);

    Patient selectByEmail(PatientLoginDto patientLoginDto);
    Patient selectById(long id);
    Boolean check(Patient patient);

    boolean CheckEmail(String email);

    Patient selectByEmailOnly(PatientLoginDto patientLoginDto);

    void changePass(Patient patient);

    void editPatient(EditPatientDto editPatientDto);

    Patient checkProfile(int id, String token);
}

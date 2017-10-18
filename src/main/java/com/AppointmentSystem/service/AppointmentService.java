package com.AppointmentSystem.service;

import com.AppointmentSystem.dto.DoctorLoginDto;
import com.AppointmentSystem.model.Appointment;
import com.AppointmentSystem.model.Doctor;

import java.util.List;

/**
 * Created by Ruzal on 8/23/2017.
 */
public interface AppointmentService {
    void insert(Appointment appointment,long id);

    List<Appointment> displayByDate(DoctorLoginDto doctorLoginDto);

    Appointment displayById(long id);
    List<String> imageName(long id);

    List<Appointment> findByDtype(Doctor doctor);

    List<Appointment> findAll();

    Boolean findByDepartmentAndDoctor(Appointment appointment);

    List<Appointment> bookedBy(long patient_id);

    List<Appointment> findAllByID(long id);

    void update(Appointment appointment);
}

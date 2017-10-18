package com.AppointmentSystem.dao;

import com.AppointmentSystem.model.Appointment;
import com.AppointmentSystem.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ruzal on 8/23/2017.
 */
public interface AppointmentDao {
    void insert(Appointment appointment);
    List<Appointment> findAll();

    List<Appointment> findAllByID(long id);

    List<Appointment> displayByDate(Doctor doctor);

    Appointment displayById(long id);
    List<String> imageName(long id);

    List<Appointment> findBtDtype(Doctor doctor);

    Boolean findByDepartmentAndDoctor(Appointment appointment);

    List<Appointment> bookedBy(long patient_id);

    void updateAppointment(Appointment appointment);
}

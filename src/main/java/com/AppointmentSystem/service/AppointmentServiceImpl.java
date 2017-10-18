package com.AppointmentSystem.service;

import com.AppointmentSystem.dao.AppointmentDao;
import com.AppointmentSystem.dto.DoctorLoginDto;
import com.AppointmentSystem.model.Appointment;
import com.AppointmentSystem.model.Doctor;
import com.AppointmentSystem.model.Document;
import com.AppointmentSystem.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentDao appointmentDao;

    @Autowired
    PatientService patientService;

    @Autowired
    DocumentService documentService;

    @Autowired
    DoctorService doctorService;

    public void insert(Appointment appointment,long id) {
        Patient patient= patientService.selectById(id);
        appointment.setName(patient.getName());
        appointment.setEmail(patient.getEmail());
        appointment.setContact(patient.getContact());
        appointment.setAddress(patient.getAddress());
        appointment.setPatient_id(patient.getId());
        appointment.setPatient_id(id);
        Document document= documentService.viewByIdd(id);
        appointment.setDocument(document.getDocuemnt());
        appointment.setSex(patient.getSex());
        appointment.setStatus("Approve?");
        appointmentDao.insert(appointment);
    }

    public List<Appointment> displayByDate(DoctorLoginDto doctorLoginDto) {
        Doctor doctor1= doctorService.getDoctorById(doctorLoginDto.getId());
        return appointmentDao.displayByDate(doctor1);
    }

    public Appointment displayById(long id) {
        return appointmentDao.displayById(id);
    }

    public List<String> imageName(long id) {
        return appointmentDao.imageName(id);
    }

    public List<Appointment> findByDtype(Doctor doctor) {
        return appointmentDao.findBtDtype(doctor);
    }

    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }

    public Boolean findByDepartmentAndDoctor(Appointment appointment) {
        return appointmentDao.findByDepartmentAndDoctor(appointment);
    }

    public List<Appointment> bookedBy(long patient_id) {
        return appointmentDao.bookedBy(patient_id);
    }

    public List<Appointment> findAllByID(long id) {
        return appointmentDao.findAllByID(id);
    }

    public void update(Appointment appointment) {
        appointmentDao.updateAppointment(appointment);
    }


}

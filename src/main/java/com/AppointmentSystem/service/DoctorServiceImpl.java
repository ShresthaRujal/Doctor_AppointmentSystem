package com.AppointmentSystem.service;

import com.AppointmentSystem.dao.DoctorDao;
import com.AppointmentSystem.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorDao doctorDao;

    public void insert(Doctor doctor) {
        doctorDao.insert(doctor);
    }

    public void delete(Doctor doctor) {
        doctorDao.delete(doctor);
    }

    public List<Doctor> doctors() {

        return doctorDao.doctors();
    }

    public void update(Doctor doctor) {
        doctorDao.update(doctor);
    }

    public Doctor getDoctor(Doctor doctor) {
        return doctorDao.getDoctor(doctor);
    }

    public List<Doctor> getDoctorByType() {
        return doctorDao.getDoctorByType();
    }

    public Doctor getDoctorById(long id) {
        return doctorDao.getDoctorById(id);
    }

    public List<Doctor> getAllDoctor(){
        return doctorDao.doctors();
    }
}

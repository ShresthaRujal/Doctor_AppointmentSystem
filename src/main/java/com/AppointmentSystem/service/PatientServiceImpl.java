package com.AppointmentSystem.service;

import com.AppointmentSystem.dao.PatientDao;
import com.AppointmentSystem.dto.EditPatientDto;
import com.AppointmentSystem.dto.PatientLoginDto;
import com.AppointmentSystem.dto.PatientRegDto;
import com.AppointmentSystem.exception.NotFoundException;
import com.AppointmentSystem.model.Patient;
import com.AppointmentSystem.utils.JwtDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientDao patientDao;


    @Autowired
    JwtDao jwtDao;

    public Boolean insert(PatientRegDto patientRegDto) {
        Patient patient= new Patient();
        patient.setEmail(patientRegDto.getEmail());
        patient.setPassword(patientRegDto.getPassword());
        patient.setAddress(patientRegDto.getAddress());
        patient.setName(patientRegDto.getName().toUpperCase());
//        patient.setToken(jwtDao.createJWT(patient));
        patient.setSex(patientRegDto.getSex());
        if (patientRegDto.getSex()=="male"){
            patient.setPp("male");
        }else{
            patient.setPp("female");
        }
        patient.setContact(patientRegDto.getContact());
        patient.setDate(patientRegDto.getDate());

        if (patientDao.insert(patient)==true){
            return true;
        }else return false;

    }

    public Patient selectByEmail(PatientLoginDto patientLoginDto) {
        Patient patient= new Patient();
        patient.setEmail(patientLoginDto.getEmail());
        patient.setPassword(patientLoginDto.getPassword());
        patient=patientDao.selectByEmail(patient);
        return patient;
    }

    public Patient selectById(long id) {
        return patientDao.selectById(id);
    }

    public Boolean check(Patient patient) {

        return patientDao.check(patient);
    }

    public boolean CheckEmail(String email) {
        for (Patient patient:patientDao.findAll()){
            if(patient.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public Patient selectByEmailOnly(PatientLoginDto patientLoginDto) {
        return patientDao.selectByEmailOnly(patientLoginDto);
    }

    public void changePass(Patient patient) {
        patientDao.changePass(patient);
    }

    public void editPatient(EditPatientDto editPatientDto) {

        Patient patient= selectById(editPatientDto.getId());
        patient.setName(editPatientDto.getName());
        patient.setContact(editPatientDto.getContact());
        patient.setAddress(editPatientDto.getAddress());
        patient.setEmail(editPatientDto.getEmail());
        patient.setDate(editPatientDto.getDate());
        patientDao.editPatient(patient);
    }

    public Patient checkProfile(int id, String token) {
        Patient patient=selectById(id);
        Patient patient1=jwtDao.verifyToken(token);
        System.out.println("patient"+patient.getName());
        System.out.println(patient.getEmail());
        System.out.println(patient1.toString());
        if (patient.getName().equals(patient1.getName()) && patient.getEmail().equals(patient1.getEmail())){
            return patient;
        }
        return null;
    }

}

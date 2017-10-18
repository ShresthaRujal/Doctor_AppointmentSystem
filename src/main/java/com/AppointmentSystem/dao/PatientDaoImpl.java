package com.AppointmentSystem.dao;

import com.AppointmentSystem.dto.PatientLoginDto;
import com.AppointmentSystem.dto.PatientRegDto;
import com.AppointmentSystem.model.Doctor;
import com.AppointmentSystem.model.Document;
import com.AppointmentSystem.model.Patient;
import com.AppointmentSystem.utils.BCrypt;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Repository("patientDao")
public class PatientDaoImpl extends AbstractDao<Long,Patient> implements PatientDao {
    public Boolean insert(Patient patient) {
       try {
           patient.setPassword(BCrypt.hashpw(patient.getPassword(), BCrypt.gensalt()));
           persist(patient);
           Document document = new Document();
           document.setId(patient.getId());
           patient.setDocument(document);
           persist(patient);
           return true;
       }catch (Exception e){
           return false;
       }
    }

    public List<Patient> findAll() {
        List<Patient> patients=entityManager.createQuery("select p from Patient p").getResultList();
        return patients;
    }

    public Patient selectByEmail(Patient patient) {
        String email=patient.getEmail();
        String pass=patient.getPassword();
        Patient patient1=null;
        System.out.println(email);
        System.out.println(pass);
        for (Patient patient2:findAll()){
            if (email.equals(patient2.getEmail()) && BCrypt.checkpw(pass,patient2.getPassword())){
                patient1=patient2;
            }

        }
        return patient1;
    }

    public Patient selectById(long id){
        Patient patient= (Patient) entityManager.createQuery("select p from Patient p where p.id=:id").setParameter("id",id).getSingleResult();
        Document document= patient.getDocument();

        return patient;
    }

    public Boolean check(Patient patient) {
        List<Patient> patients=findAll();
        for (Patient patient1:patients){
            if(patient.getEmail().equals(patient1.getEmail())){
                return true;
            }
        }
        return false;
    }

    public Patient selectByEmailOnly(PatientLoginDto patientLoginDto) {
        List<Patient> patient=findAll();
        Patient patient2=null;
        for (Patient patient1:patient){
            if (patient1.getEmail().equals(patientLoginDto.getEmail())) {
                patient2=patient1;
            }
        }
        return patient2;
    }

    public void changePass(Patient patient) {
        update(patient);
    }

    public void editPatient(Patient patient) {
        update(patient);
    }


}

package com.AppointmentSystem.dao;

import com.AppointmentSystem.model.Doctor;
import com.AppointmentSystem.utils.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.List;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Repository("DoctorDao")
public class DoctorDaoImpl extends AbstractDao<Long,Doctor> implements DoctorDao {
    public void insert(Doctor doctor) {

    }

    public void delete(Doctor doctor) {

    }

    public List<Doctor> doctors() {
        List<Doctor> doctors=entityManager.createQuery("SELECT d from Doctor d").getResultList();
        return doctors;

    }

    public void update(Doctor doctor) {

    }

    public Doctor getDoctor(Doctor doctor) {
        Doctor doctor1=null;
        System.out.println(doctor.getDpass());
        for (Doctor doctor2:doctors()){
            if ((doctor2.getDid()==doctor.getDid()) && BCrypt.checkpw(doctor.getDpass(),doctor2.getDpass())){
                doctor1=doctor2;
            }
        }
        return doctor1;
    }

    public List<Doctor> getDoctorByType() {
        List<Doctor> doctors= entityManager.createQuery("select d.Dtype from Doctor d").getResultList();
        return doctors;
    }

    public Doctor getDoctorById(long id) {
        Doctor doctor=getByKey(id);
        return doctor;
    }
}

package com.AppointmentSystem.dao;

import com.AppointmentSystem.model.Appointment;
import com.AppointmentSystem.model.Doctor;
import com.AppointmentSystem.service.DateService;
import com.AppointmentSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Repository
public class AppointmentDaoImpl extends AbstractDao<Long,Appointment> implements AppointmentDao {
    @Autowired
    DateService dateService;


    public void insert(Appointment appointment) {
        appointment.setNow(new Date());
        persist(appointment);
    }

    public List<Appointment> findAll(){
        List<Appointment> appointments=entityManager.createQuery("SELECT a from Appointment a").getResultList();
        return appointments;
    }

    public List<Appointment> findAllByID(long id){
        List<Appointment> appointments= (List<Appointment>) entityManager.createQuery("select a from Appointment a where a.id=:id order by a.id desc").setParameter("id",id);
        return appointments;
    }

    public List<Appointment> displayByDate(Doctor doctor) {
        List<Appointment> appointments= new ArrayList<Appointment>();
        for (Appointment appointment:findAll()) {
            if (appointment.getDate().equals(dateService.getCurrentFullDate()) && doctor.getDtype().equals(appointment.getDepartment())){
                appointments.add(appointment);
            }
        }
            return appointments;
    }

    public Appointment displayById(long id) {
        Appointment appointment= (Appointment) entityManager.createQuery("select a from Appointment a where a.id=:id").setParameter("id",id).getSingleResult();
        return appointment;
    }

    public List<String> imageName(long id){
        Appointment appointment=displayById(id);
        String image= appointment.getDocument();
        List<String> imgstr=new ArrayList<String>();

        StringTokenizer t= new StringTokenizer(image);
        String word="";
        while(t.hasMoreTokens()){
            word=t.nextToken();
            imgstr.add(word);
        }
        return imgstr;
    }

    public List<Appointment> findBtDtype(Doctor doctor) {
        List<Appointment> appointments=new ArrayList<Appointment>();
        for (Appointment appointment: findAll()){
            if (appointment.getDepartment().equals(doctor.getDtype())){
                appointments.add(appointment);;
            }
        }
        return appointments;
    }

    public Boolean findByDepartmentAndDoctor(Appointment appointment) {
        List<Appointment> appointments= findAll();
        for (Appointment appointment1:appointments){
            if (appointment1.getDepartment().equals(appointment.getDepartment()) && appointment1.getDoctor().equals(appointment.getDoctor())){
                if (appointment1.getDate().equals(appointment.getDate())){
                    if (appointment1.getTime()==appointment.getTime() && appointment1.getTimeMM()==appointment.getTimeMM()) {
                    System.out.println(true);
                    return true;
                }
                }
            }
        }
        System.out.println(false);
        return false;
    }

    public List<Appointment> bookedBy(long patient_id) {

        List<Appointment> appointment=entityManager.createQuery("SELECT a from Appointment a where a.patient_id=:id").setParameter("id",patient_id).getResultList();
        List<Appointment> appointments=new ArrayList<Appointment>();
        for (Appointment appointment1:appointment){
            if (appointment1.getDate().equals(dateService.getCurrentFullDate())){
                appointments.add(appointment1);
                System.out.println("date matched");
            }
        }
        return appointments;
    }

    public void updateAppointment(Appointment appointment) {
        update(appointment);
    }
}

package com.AppointmentSystem.controller.restApi;

import com.AppointmentSystem.dto.DoctorLoginDto;
import com.AppointmentSystem.model.Appointment;
import com.AppointmentSystem.model.Doctor;
import com.AppointmentSystem.model.Document;
import com.AppointmentSystem.model.Patient;
import com.AppointmentSystem.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ruzal on 9/17/2017.
 */
@RestController
@RequestMapping(value = "/api/v1/doctors")
public class ControllerDoctor {

    private static final Logger Log= Logger.getLogger(ControllerDoctor.class);

    @Autowired
    DoctorService doctorService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    PatientService patientService;

    @Autowired
    DocumentService documentService;

    @Autowired
    MailService mailService;
    //doctor appointment list
    @GetMapping("/appointmentlist/{id}")
    public ResponseEntity<Object> appointmentList(@PathVariable("id") long id ){
        try {
            Doctor doctor = doctorService.getDoctorById(id);
            DoctorLoginDto doctorLoginDto= new DoctorLoginDto();
            doctorLoginDto.setId(doctor.getDid());

            List<Appointment> appointments = appointmentService.displayByDate(doctorLoginDto);
            if (appointments==null){
                Map<String, String> map= new HashMap<String, String>();
                map.put("result","No Appointments for Today!");
                return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Object>(appointments, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }

    //    patient profile for doctor
    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> patientProfile(@PathVariable("id") long id){
        Patient patient=patientService.selectById(id);
        patient.setPp("http://10.10.20.123:8520/resources/image/"+patient.getPp());

        List<String> document =documentService.viewById(id);
        if (document==null){
            return new ResponseEntity<Patient>(patient,HttpStatus.OK);
        }
        List<String> docwithPath=new ArrayList<String>();
        for (String stringDocument:document){
            docwithPath.add("http://10.10.20.123:8520/resources/image/"+stringDocument+" ");
        }
        String string="";
        for (String doc: docwithPath){
            string=string+doc;
        }
        Document document1= new Document(patient.getId(),string);
        patient.setDocument(document1);
        return new ResponseEntity<Patient>(patient,HttpStatus.OK);
    }

    //    doctor login
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> docLogin(@Valid DoctorLoginDto doctorLoginDto, BindingResult result){

        Map<String,String> map=new HashMap<String, String>();
        if (result.hasErrors()|| String.valueOf(doctorLoginDto.getId()).length()<4){
            Log.info(result);
            map.put("result","Error-->"+result);
            return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
        }
        Doctor doctor=new Doctor();
        doctor.setDid(doctorLoginDto.getId());
        doctor.setDpass(doctorLoginDto.getPass());
        doctor=doctorService.getDoctor(doctor);
        if (doctor!=null){
            map.put("result","Login Successsfull!");
            map.put("id", String.valueOf(doctor.getDid()));
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }else {
            map.put("result","Doctor not found!");
            return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/appointments/approval/{idd}")
    public ResponseEntity<Object> appointmentApproval(@PathVariable("idd") long idd){
        Appointment appointment=appointmentService.displayById(idd);
        Map<Object,Object> map=new HashMap<Object, Object>();
        System.out.println(appointment.getStatus());
        if (appointment.getStatus().equals("Approved!!")) {
            appointment.setStatus("Approve!");
            appointmentService.update(appointment);
            mailService.sendEmail(appointment,"appointmentrejected");
            map.put("result","Approved undone");
        }else {
            appointment.setStatus("Approved!!");
            appointmentService.update(appointment);
            mailService.sendEmail(appointment,"appointmentapproval");
            map.put("result","Approved");
        }
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Object> doctorlist(){
        return new ResponseEntity<Object>(doctorService.getAllDoctor(),HttpStatus.OK);
    }
}

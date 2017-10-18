package com.AppointmentSystem.controller.restApi;

import com.AppointmentSystem.dto.ForgotPassDto;
import com.AppointmentSystem.dto.PatientLoginDto;
import com.AppointmentSystem.dto.PatientRegDto;
import com.AppointmentSystem.exception.ValidationException;
import com.AppointmentSystem.model.Appointment;
import com.AppointmentSystem.model.Document;
import com.AppointmentSystem.model.Patient;
import com.AppointmentSystem.responseDto.LoginResponseDto;
import com.AppointmentSystem.service.*;
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

/*
 * Created by Ruzal on 8/23/2017.
 */

@RestController
@RequestMapping("/api/v1/patients")
public class ControllerPatient {
    @Autowired
    AppointmentService appointmentService;

    @Autowired
    PatientService patientService;

    @Autowired
    DocumentService documentService;
    @Autowired
    MailService mailService;

    @Autowired
    PasswordService passwordService;


//    patient login
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> patientLogin(@Valid PatientLoginDto patientLoginDto, BindingResult result) {

        Map<String, String> map = new HashMap<String, String>();
        if (result.hasErrors()){
        map.put("result","Invalid Username and Password!");
        return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
        }
        if (patientLoginDto.getEmail()!=null && patientLoginDto.getPassword()!=null){
            Patient patient= patientService.selectByEmail(patientLoginDto);
            if (patient==null){
            map.put("result","User doesnot Exist!");
            return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
            }else {
                LoginResponseDto loginResponseDto= new LoginResponseDto(patient.getId(),patient.getToken());
                return new ResponseEntity<Object>(loginResponseDto, HttpStatus.OK);
            }
        }
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }
//patient document
    @GetMapping(value="/document/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Document> patientDoc(@PathVariable("id") long id){
        Document document= documentService.viewByIdd(id);
        return new ResponseEntity<Document>(document,HttpStatus.OK);
    }
//book appointment
    @PostMapping(value = "/appointment/{idd}",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> appointmentReg(@Valid Appointment appointment,BindingResult result, @PathVariable("idd") long id){
        Map<Object,Object> map= new HashMap<Object, Object>();
        if (result.hasErrors()){
            map.put("result","Bad Inputs!");
            return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
        }
        if (appointment.getDepartment().equals(null) && appointment.getDoctor().equals(null) && appointment.getDate().equals(null)){
            map.put("result","Choose Doctor and Departments!!");
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
        if(appointmentService.findByDepartmentAndDoctor(appointment)) {
            map.put("result","Time and Date are already reserved.");
            return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
        }
        try{
        appointmentService.insert(appointment,id);
        map.put("result","Appointment Registered!!");
        return new ResponseEntity<Object>(map,HttpStatus.OK);
        }catch (Exception e){
            map.put("result","Registration Failure! Dublicate data.");
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }

    }


//    patient documents
    @GetMapping("/document/{id}")
    public ResponseEntity<Document> documentRespose(@PathVariable("id") long id){
        List<String> document =documentService.viewById(id);
        if (document==null){
            return new ResponseEntity<Document>(HttpStatus.OK);
        }
        List<String> docwithPath=new ArrayList<String>();
        for (String stringDocument:document){
            docwithPath.add("http://10.10.20.123:8520/resources/image/"+stringDocument+" ");
        }
        String string="";
        for (String doc: docwithPath){
            string=string+doc;
        }
        Document document1= new Document();
        document1.setId(id);
        document1.setDocuemnt(string);
        return new ResponseEntity<Document>(document1,HttpStatus.OK);
    }

//    patient register
    @PostMapping(value="/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String,String>> regPatient(@Valid PatientRegDto patientRegDto,BindingResult result) {

        Map<String, String> map = new HashMap<String, String>();
        Patient patient= new Patient();
        patient.setEmail(patientRegDto.getEmail());
        if (result.hasErrors()){
            map.put("result","Bad Credentials!!");
            return new ResponseEntity<Map<String, String>>(map,HttpStatus.OK);
        }
        if (patientRegDto.getEmail().equals("") && patientRegDto.getPassword().equals("") && patientRegDto.getName().equals("")
                && patientRegDto.getAddress().equals("") && patientRegDto.getContact().equals("")
                && patientRegDto.getDate().equals("")) {
            map.put("result", "Registration Failure! Input all credientials");
            return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
        }else if(patientService.check(patient)){
            map.put("result","user already exists!!");
            return new ResponseEntity<Map<String, String>>(map,HttpStatus.OK);
        }else {
            if (patientService.insert(patientRegDto) == true) {
                map.put("result", "Registration Successfull!");
                return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
            } else {
                map.put("result", "Registration Failure!");
                return new ResponseEntity<Map<String, String>>(HttpStatus.OK);
            }
        }

    }

//patient todays appointment list
    @GetMapping(value = "/appointmentlist/{id}")
    public ResponseEntity<List<Appointment>> todayAppointment(@PathVariable("id") long id){
        try {
            List<Appointment> appointments = appointmentService.bookedBy(id);

            return new ResponseEntity<List<Appointment>>(appointments, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Appointment>>(HttpStatus.OK);
        }
    }


//appointment history
    @GetMapping(value = "/appointments/{id}")
    public ResponseEntity<Object> allappointments(@PathVariable long id){
        return new ResponseEntity<Object>(appointmentService.findAllByID(id),HttpStatus.OK);
    }

    @PostMapping(value = "/passwordrecovery", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> passwordRecovery(@Valid ForgotPassDto forgotPassDto, BindingResult result ){
        if (result.hasErrors()){
            throw new ValidationException("Email is invalid!!");
        }
        if(passwordService.forgotPass(forgotPassDto)){
            Map<String,String> map=new HashMap<String, String>();
            map.put("result","Check your email to recover your password!");
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping(value = "/profile")
    public ResponseEntity<Object> patientProfile(@RequestHeader int id){
        Patient patient=patientService.selectById(id);
        if (!patient.equals(null)){
            return new ResponseEntity<Object>(patient,HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }


}

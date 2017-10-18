package com.AppointmentSystem.controller;

import com.AppointmentSystem.dto.DoctorLoginDto;
import com.AppointmentSystem.model.Appointment;
import com.AppointmentSystem.model.Doctor;
import com.AppointmentSystem.model.Patient;
import com.AppointmentSystem.service.AppointmentService;
import com.AppointmentSystem.service.DoctorService;
import com.AppointmentSystem.service.DocumentService;
import com.AppointmentSystem.service.PatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Controller
@RequestMapping(value = "/appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    DocumentService documentService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    final static Logger logger = Logger.getLogger(AppointmentController.class);

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String appointmentPage(@PathVariable("id") long id, ModelMap modelMap) {
        logger.info("Redirecting to appointment page.");
        List<Doctor> doctors = doctorService.doctors();
        Patient patient= patientService.selectById(id);
        modelMap.addAttribute("doctors", doctors);
        modelMap.addAttribute("size",appointmentService.bookedBy(patient.getId()).size());
        modelMap.addAttribute("myappointments",appointmentService.bookedBy(patient.getId()));
        modelMap.addAttribute("patient", patient);
        modelMap.addAttribute("appointment", new Appointment());
        return "appointment/AppointmentReg";
    }

    @RequestMapping(value = "/{idd}",method = RequestMethod.POST)
    public String docInfo(@Valid Appointment appointment,BindingResult result,
                          @PathVariable("idd") long id, ModelMap modelMap){
        List<Doctor> doctors = doctorService.doctors();
        System.out.println("select by id patient"+appointment.toString());
        Patient patient= patientService.selectById(id);
        modelMap.addAttribute("doctors", doctors);
        modelMap.addAttribute("patient", patientService.selectById(id));
        modelMap.addAttribute("size",appointmentService.bookedBy(patient.getId()).size());
        modelMap.addAttribute("myappointments",appointmentService.bookedBy(patient.getId()));
        modelMap.addAttribute("appointment", appointment);
        if (result.hasErrors()) {
            System.out.println("registration error");
            logger.error("registration error :" + result);
            return "appointment/Appointment";
        }else if(appointmentService.findByDepartmentAndDoctor(appointment)) {
            System.out.println("findByDepartmentandDotro");
            modelMap.addAttribute("timemessage","Requested time is already reserved.");
            return "appointment/AppointmentReg";
        }else {
            System.out.println("insertinggggggggggggggg");
            appointmentService.insert(appointment,id);
            modelMap.addAttribute("size",appointmentService.bookedBy(patient.getId()).size());
            modelMap.addAttribute("myappointments",appointmentService.bookedBy(patient.getId()));
            modelMap.addAttribute("alert", "alert('Appointment is in Queue. We will notify you soon.');");
            return "Paitent/timeline";
        }
    }




}

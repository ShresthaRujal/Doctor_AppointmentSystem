package com.AppointmentSystem.controller;

import com.AppointmentSystem.dto.DoctorLoginDto;
import com.AppointmentSystem.model.Appointment;
import com.AppointmentSystem.model.Doctor;
import com.AppointmentSystem.service.AppointmentService;
import com.AppointmentSystem.service.DoctorService;
import com.AppointmentSystem.service.MailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.Doc;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Controller
@RequestMapping(value = "/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    MailService mailService;

    final static Logger logger = Logger.getLogger(PatientController.class);

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String docLogin(ModelMap modelMap){
        logger.info("Redirecting Doctor login.");
        modelMap.addAttribute("doctorLoginDto",new DoctorLoginDto());
        return "Doctor/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@Valid DoctorLoginDto doctorLoginDto, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()|| String.valueOf(doctorLoginDto.getId()).length()<4) {
            logger.error("Validation Error!");
            modelMap.addAttribute("idmessage","Id must be greater than 4 and less than 10.");
            modelMap.addAttribute("doctorLoginDto", doctorLoginDto);
            return "Doctor/login";
        }
            Doctor doctor= doctorService.getDoctorById(doctorLoginDto.getId());
//            List<Appointment> appointments= appointmentService.displayByDate(doctorLoginDto);

            modelMap.addAttribute("notify","alert('Login Successfull!');");
            modelMap.addAttribute("doctor",doctor);
//            if (appointments==null){
//                logger.error("Appointment is null.");
//                return "Doctor/appointment";
//            }else {
//                modelMap.addAttribute("appointment", appointments);
                return "Doctor/doctorTimeline";
//            }
        }

    @RequestMapping(value = "/viewPatients/{id}",method = RequestMethod.GET)
    public String patientProfile(@PathVariable("id") long id, ModelMap modelMap){
            Appointment appointment=appointmentService.displayById(id);
            modelMap.addAttribute("profile",appointment);
            if(appointment.getDocument()==null){
                return "Doctor/patientProfile";
            }else{
                modelMap.addAttribute("image",appointmentService.imageName(id));
                return "Doctor/patientProfile";
            }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String doctorProfile(@PathVariable("id") long id,ModelMap modelMap){
        modelMap.addAttribute("doctor",doctorService.getDoctorById(id));
        return "Doctor/doctorTimeline";
    }

    @RequestMapping(value = "/appointment/requested/{id}",method = RequestMethod.GET)
    public String appointments(@PathVariable("id") Long id,ModelMap modelMap){
        DoctorLoginDto doctorLoginDto= new DoctorLoginDto();
        doctorLoginDto.setId(id);
        List<Appointment> appointments=appointmentService.displayByDate(doctorLoginDto);
        for (Appointment appointment: appointments){
            System.out.println(appointment.getName());
            System.out.println(appointment.getStatus());
        }
        modelMap.addAttribute("appointments",appointments);
        modelMap.addAttribute("id",id);
        Doctor doctor= doctorService.getDoctorById(doctorLoginDto.getId());
        modelMap.addAttribute("doctor",doctor);
        return "Doctor/requestedAppointment";
    }

    @RequestMapping(value = "/doctorAppointments/{id}/doctorAppointmentsApproval/{idd}",method = RequestMethod.GET)
    public String approval(@PathVariable("idd") long idd, @PathVariable("id") long id, @RequestParam("value") int number){
        Appointment appointment=appointmentService.displayById(idd);
        if (!appointment.getStatus().equals("Approved!!")) {
            appointment.setStatus("Approved!!");
            appointmentService.update(appointment);
            mailService.sendEmail(appointment,"appointmentapproval");
        }else {
            appointment.setStatus("Approve?");
            appointmentService.update(appointment);
            mailService.sendEmail(appointment,"appointmentrejected");
        }
        if (number==1) {
            return "redirect:/doctorAppointments/" + id;
        }else {
            return "redirect:/appointment/approved/"+id;
        }
    }

    @RequestMapping(value = "/appointment/approved/{id}",method = RequestMethod.GET)
    public String approvedAppointmetns(@PathVariable("id") long id,ModelMap modelMap){
        System.out.println(id);
        DoctorLoginDto doctorLoginDto= new DoctorLoginDto();
        doctorLoginDto.setId(id);
        List<Appointment> appointments=appointmentService.displayByDate(doctorLoginDto);
        List<Appointment> appointmentList=new ArrayList<Appointment>();
        for (Appointment appointment: appointments){
            if (appointment.getStatus().equals("Approved!!")){
                appointmentList.add(appointment);
            }
        }
        modelMap.addAttribute("appointments",appointmentList);
        Doctor doctor= doctorService.getDoctorById(doctorLoginDto.getId());
        modelMap.addAttribute("doctor",doctor);
        return "Doctor/approvedAppointment";
    }


}

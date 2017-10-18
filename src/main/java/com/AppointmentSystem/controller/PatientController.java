package com.AppointmentSystem.controller;

import com.AppointmentSystem.dto.EditPatientDto;
import com.AppointmentSystem.dto.ForgotPassDto;
import com.AppointmentSystem.dto.PatientLoginDto;
import com.AppointmentSystem.dto.PatientRegDto;
import com.AppointmentSystem.model.Appointment;
import com.AppointmentSystem.service.AppointmentService;
import com.AppointmentSystem.service.PasswordService;
import com.AppointmentSystem.utils.JwtDao;
import com.AppointmentSystem.model.Document;
import com.AppointmentSystem.model.Patient;
import com.AppointmentSystem.service.DocumentService;
import com.AppointmentSystem.service.PatientService;
import org.apache.log4j.Logger;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Controller
@RequestMapping(value = "/patients")
public class PatientController {

    private static final Logger Log=Logger.getLogger(PatientController.class);

    @Autowired
    PatientService patientService;

    @Autowired
    DocumentService documentService;

    @Autowired
    AppointmentService appointmentService;


    final static Logger logger = Logger.getLogger(PatientController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("document");
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String pLoginPage(ModelMap modelMap){

        modelMap.addAttribute("patientLoginDto",new PatientLoginDto());
        return "Paitent/patientLogin";
    }

    @RequestMapping(value = "/regPatient",method = RequestMethod.GET)
    public String registerForm(ModelMap modelMap,PatientRegDto patientRegDto){
        modelMap.addAttribute("patientRegDto",patientRegDto);
        return "Paitent/regForm";
    }

    @RequestMapping(value = "/regPatient", method = RequestMethod.POST)
    public String registerPatient(@Valid PatientRegDto patientRegDto, BindingResult result, ModelMap modelMap) {
        logger.debug("Registering Patient.");
        modelMap.addAttribute("patientRegDto", patientRegDto);
        if (result.hasErrors()) {
            return "Paitent/regForm";
        }else if(patientService.CheckEmail(patientRegDto.getEmail())){
            modelMap.addAttribute("emailmessage","Account with Your email is already registered!");
            return "Paitent/regForm";
        }else {
            patientService.insert(patientRegDto);
            modelMap.addAttribute("notice", "alert('You have been Registered. Login to confirm!');");
            modelMap.addAttribute("patientLoginDto",new PatientLoginDto());
            return "Paitent/patientLogin";
        }
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@Valid PatientLoginDto patientLoginDto, BindingResult result,
                        ModelMap modelMap, HttpServletRequest request){

        modelMap.addAttribute("patientLoginDto", patientLoginDto);
        if (result.hasErrors()){
            return "Paitent/patientLogin";
        }else {
            logger.debug("Select by email.");
            Patient patient = patientService.selectByEmail(patientLoginDto);
            if (patient == null) {
                logger.error("User not found!!");
                modelMap.addAttribute("message","User not found!!");
                return "Paitent/patientLogin";
            } else {
                modelMap.addAttribute("size",appointmentService.bookedBy(patient.getId()).size());
                modelMap.addAttribute("myappointments",appointmentService.bookedBy(patient.getId()));
                modelMap.addAttribute("patient", patient);
                modelMap.addAttribute("alert", "alert('Welcome " + patient.getName() + "!');");
                return "Paitent/timeline";
            }
        }
    }

    @RequestMapping(value = "/document/{id}",method = RequestMethod.GET)
    public String mydocument(@PathVariable("id") long id, ModelMap modelMap) {
            modelMap.addAttribute("document", new Document());
            modelMap.addAttribute("id", id);
            List<String> document = documentService.viewById(id);
                Patient patient = patientService.selectById(id);
                modelMap.addAttribute("size",appointmentService.bookedBy(patient.getId()).size());
                modelMap.addAttribute("myappointments",appointmentService.bookedBy(patient.getId()));
                modelMap.addAttribute("patient", patient);
                modelMap.addAttribute("file", document);
                return "Paitent/myDocument";
    }

    @RequestMapping(value="/document/{id}",method = RequestMethod.POST)
    public String saveDocument(@ModelAttribute("document") Document documents, BindingResult result, @RequestParam CommonsMultipartFile[] document,
                               HttpServletRequest request,ModelMap modelMap,@PathVariable("id") long id,
                               HttpSession session) {

        System.out.println("reached");
        if (result.hasErrors()) {
            return "Paitent/myDocument";
        } else {
            String token = (String) session.getAttribute("token");
                System.out.println("inserting image");
                String filenames = "";
                int i = 0;
                ArrayList<String> imageStr = new ArrayList<String>();
                for (CommonsMultipartFile images : document) {
                    String path = request.getRealPath("resources/image");
                    String filename = new SimpleDateFormat("yyyyMMddHHmm" + i + " ").format(new Date());
                    System.out.println(path + ":" + filename);

                    try {
                        byte[] bytes = images.getBytes();
                        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + File.separator + filename)));
                        stream.write(bytes);
                        stream.flush();
                        stream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                    filenames = filenames + filename;
                    i++;
                }
                documents.setDocuemnt(filenames);

                documentService.updateD(documents, id);

                System.out.println(filenames);

                request.setAttribute("tokan", token);
                return "redirect:/patients/document/" + id + "";
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session,HttpServletRequest request,ModelMap modelMap){
        session=request.getSession();
        session.invalidate();
        modelMap.addAttribute("gogo","alert('Logout Successfull');");
        modelMap.addAttribute("patient",new Patient());
        return "Paitent/patientLogin";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String appointmentPage(@PathVariable("id") long id, ModelMap modelMap){
        Patient patient= patientService.selectById(id);
            if (patient.getPp()==null) {
                patient.setPp("empty");
            }
                modelMap.addAttribute("patient",patient);
                return "Paitent/profile";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editPage(ModelMap modelMap,@PathVariable("id") long id, EditPatientDto editPatientDto){
        Patient patient=patientService.selectById(id);
        editPatientDto.setName(patient.getName());
        editPatientDto.setAddress(patient.getAddress());
        editPatientDto.setContact(patient.getContact());
        editPatientDto.setEmail(patient.getEmail());
        editPatientDto.setDate(patient.getDate());
        modelMap.addAttribute("editPatientDto",editPatientDto);
        return "Paitent/editPatient";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public String edit(@Valid EditPatientDto editPatientDto, BindingResult result, @PathVariable("id") long id, ModelMap modelMap){
        if (result.hasErrors()){
            System.out.println(result);
            modelMap.addAttribute("editPatientDto",new EditPatientDto());
            return "Paitent/editPatient";
        }else {
            editPatientDto.setId(id);
            patientService.editPatient(editPatientDto);
            Patient patient= patientService.selectById(id);
            modelMap.addAttribute("notice", "alert('You have been Registered. Login to confirm!');");
            modelMap.addAttribute("patient",patient);
            return "Paitent/profile";
        }
    }


}
package com.AppointmentSystem.controller;

import com.AppointmentSystem.dto.ForgotPassDto;
import com.AppointmentSystem.dto.NewPassDto;
import com.AppointmentSystem.dto.PatientLoginDto;
import com.AppointmentSystem.model.Patient;
import com.AppointmentSystem.service.PasswordService;
import com.AppointmentSystem.service.PatientService;
import com.AppointmentSystem.utils.BCrypt;
import com.AppointmentSystem.utils.JwtDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Ruzal on 9/5/2017.
 */
@Controller
@RequestMapping(value = "/password")
public class PasswordController {

    @Autowired
    PasswordService passwordService;

    @Autowired
    PatientService patientService;

    @Autowired
    JwtDao jwtDao;

    @RequestMapping(value = "/forgot",method = RequestMethod.GET)
    public String forgotPassword(ModelMap modelMap){
        modelMap.addAttribute("forgotPassDto",new ForgotPassDto());
        return "Paitent/recoverPass";
    }

    @RequestMapping(value = "/recover",method = RequestMethod.POST)
    public String recoveryPass(@Valid ForgotPassDto forgotPassDto, BindingResult result, ModelMap modelMap){
        if (result.hasErrors()){
            modelMap.addAttribute("forgot",forgotPassDto);
            return "Paitent/recoverPass";
        }else {
            if(passwordService.forgotPass(forgotPassDto)){
                modelMap.addAttribute("recoverymsg","alert('We have send you an email to recovery your password.');");
                return "Paitent/patientLogin";
            }else {
                modelMap.addAttribute("recoverymsg","alert('Sorry! User associated with this Email not found!');");
                return "Paitent/recoverPass";
            }

        }
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String editPassword(HttpServletRequest request,ModelMap modelMap){
        String str=request.getParameter("token");
        Patient patient=jwtDao.verifyToken(str);
        if (patientService.check(patient)){
            PatientLoginDto patientLoginDto= new PatientLoginDto();
            patientLoginDto.setEmail(patient.getEmail());
            Patient patient1= patientService.selectByEmailOnly(patientLoginDto);
            modelMap.addAttribute("id",patient1.getId());
            modelMap.addAttribute("newPassDto",new NewPassDto());
            return "Paitent/newPass";
        }
        return null;
    }

    @RequestMapping(value = "/new/{id}",method = RequestMethod.POST)
    public String newPasS(@Valid NewPassDto newPassDto, BindingResult result, ModelMap modelMap, @PathVariable("id") long id){
        if (result.hasErrors()){
            modelMap.addAttribute("newPassDto",newPassDto);
            return "Paitent/newPass";
        }else if(newPassDto.getPassword().equals(newPassDto.getPasswordagain())){

            Patient patient= patientService.selectById(id);
            patient.setPassword(BCrypt.hashpw(newPassDto.getPassword(),BCrypt.gensalt()));
            patientService.changePass(patient);
            modelMap.addAttribute("passmessage","alert('Your password changed successfully! login to confirm!');");
            modelMap.addAttribute("patientLoginDto",new PatientLoginDto());
            return "Paitent/patientLogin";
        }else{
            modelMap.addAttribute("passmessage","Password didn't match.");
            modelMap.addAttribute("newPassDto",newPassDto);
            return "Paitent/newPass";
        }
    }
}

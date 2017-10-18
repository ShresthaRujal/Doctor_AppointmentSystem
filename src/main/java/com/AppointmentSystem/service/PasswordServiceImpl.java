package com.AppointmentSystem.service;

import com.AppointmentSystem.dto.ForgotPassDto;
import com.AppointmentSystem.dto.PatientLoginDto;
import com.AppointmentSystem.model.Patient;
import com.AppointmentSystem.utils.JwtDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ruzal on 9/5/2017.
 */
@Service
@Transactional
public class PasswordServiceImpl implements PasswordService{

    @Autowired
    JwtDao jwtDao;

    @Autowired
    PatientService patientService;

    @Autowired
    MailService mailService;

    public Boolean forgotPass(ForgotPassDto forgotPassDto) {
        PatientLoginDto patientLoginDto = new PatientLoginDto();
        patientLoginDto.setEmail(forgotPassDto.getEmail());
        System.out.println(patientLoginDto.getEmail());
        Patient patient = patientService.selectByEmailOnly(patientLoginDto);

        try{
            String token = jwtDao.createJWT(patient);
            patient.setToken(token);
            return mailService.sendEmail(patient,"forgotpassword");

        }catch (NullPointerException e){
            return false;
        }
    }
}

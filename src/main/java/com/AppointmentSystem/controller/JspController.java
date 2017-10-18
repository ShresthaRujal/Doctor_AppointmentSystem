package com.AppointmentSystem.controller;

import com.AppointmentSystem.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Controller
public class JspController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "test";
    }



}

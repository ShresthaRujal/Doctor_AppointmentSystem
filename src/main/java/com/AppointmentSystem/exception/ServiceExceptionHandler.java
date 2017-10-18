//package com.AppointmentSystem.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
///**
// * Created by Ruzal on 9/17/2017.
// */
//@ControllerAdvice
//public class ServiceExceptionHandler {
//
//    @ExceptionHandler(NotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public Error handleNotFoundException(Exception notFoundException){
//        return new Error(HttpStatus.NOT_FOUND.value(),notFoundException.getMessage());
//    }
//}

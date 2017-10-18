package com.AppointmentSystem.exception;

/**
 * Created by Ruzal on 9/17/2017.
 */
public class ServiceException extends RuntimeException{
    private String message;

    public ServiceException(String message){
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

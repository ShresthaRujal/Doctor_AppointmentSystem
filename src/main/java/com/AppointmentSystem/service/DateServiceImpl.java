package com.AppointmentSystem.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Service
public class DateServiceImpl implements DateService {
    public String getCurrentFullDate() {
        Calendar cal = Calendar.getInstance();
        String date=null;
        String day= String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        if (day.length()<2){
            day="0"+day;
        }
        String month= String.valueOf(cal.get(Calendar.MONTH));
        if (month.length()<2){
            month="0"+(Integer.parseInt(month)+1);
        }
        int year=cal.get(Calendar.YEAR);
        date=(month)+"/"+day+"/"+year;
        return date;
    }
}

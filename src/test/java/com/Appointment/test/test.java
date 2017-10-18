package com.Appointment.test;

/**
 * Created by Ruzal on 8/29/2017.
 */

import com.AppointmentSystem.model.Patient;
import com.AppointmentSystem.utils.BCrypt;
import com.AppointmentSystem.utils.JwtDao;
import com.AppointmentSystem.utils.JwtDaoImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Ruzal on 8/29/2017.
 */
public class test {
//    @Autowired


    public static void main(String args[]) {
        JwtDao jwtDao = new JwtDaoImpl();
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwIiwiaWF0IjoxNTA1NTMzMzI0LCJzdWIiOiJSQUdIVSBCSEFUVEEiLCJpc3MiOiJyYWdodTU1LmJoYXR0YUBnbWFpbC5jb20iLCJleHAiOjE1MDU1MzUxNjB9.NlQUS8aiaDHEM1e10CgJjDAkNoHtfH8RRK0LEbkgBsI";
        Patient patient = jwtDao.verifyToken(token);
        System.out.println(patient.getName());

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary("*AppointmentManagement#"))
                    .parseClaimsJws(token).getBody();
            System.out.println(claims.getIssuer());
            System.out.println(claims.getSubject());
//        if (doctor.getDname().equals(claims.getSubject()) && doctor.getDid()==Integer.parseInt(claims.getId())) {
//            System.out.println("true");
//            return true;
//        }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("false");
//        return false;
        }
    }
}

package com.AppointmentSystem.utils;

import com.AppointmentSystem.model.Doctor;
import com.AppointmentSystem.model.Patient;

/**
 * Created by Ruzal on 8/26/2017.
 */
public interface JwtDao {
    String createJWT(Patient patient);
    Patient verifyToken(String token);

    String createJWT(Doctor doctor);
    boolean verifyToken(String token,Doctor doctor);

}

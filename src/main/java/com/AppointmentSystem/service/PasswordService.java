package com.AppointmentSystem.service;

import com.AppointmentSystem.dto.ForgotPassDto;
import org.springframework.stereotype.Service;

/**
 * Created by Ruzal on 9/5/2017.
 */

public interface PasswordService {
    Boolean forgotPass(ForgotPassDto forgotPassDto);
}

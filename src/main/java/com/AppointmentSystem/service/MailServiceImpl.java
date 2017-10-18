package com.AppointmentSystem.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.AppointmentSystem.model.Appointment;
import com.AppointmentSystem.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;

	public Boolean sendEmail(Object object,String string) {
		System.out.println("mail"+string);
		MimeMessagePreparator preparator=null;
		if (string.equals("forgotpassword")) {
			Patient patient= (Patient) object;
			preparator = getMessagePreparator(patient, string);
		}
		if (string.equals("appointmentapproval")){
			Appointment appointment = (Appointment) object;
			preparator = getMessagePreparator(appointment, string);
		}
		if (string.equals("appointmentrejected")){
			Appointment appointment = (Appointment) object;
			preparator = getMessagePreparator(appointment, string);
		}
		try {
			mailSender.send(preparator);
			System.out.println("Message Send...Hurrey");
			return true;
			} catch (MailException ex) {
			System.err.println(ex.getMessage());
			return false;
		}
	}

	private MimeMessagePreparator getMessagePreparator(final Object object,String string) {

		if (string.equals("forgotpassword")) {
			final Patient patient= (Patient) object;
			MimeMessagePreparator preparator = new MimeMessagePreparator() {

				public void prepare(MimeMessage mimeMessage) throws Exception {
					mimeMessage.setFrom("zeroxlucifer24@gmail.com");
					mimeMessage.setRecipient(Message.RecipientType.TO,
							new InternetAddress(patient.getEmail()));
					mimeMessage.setText("Click, to recover " + "http://10.10.20.250:8520/password?token=" + patient.getToken());
					mimeMessage.setSubject("Recover your password!");
				}
			};
			return preparator;
		}
		if (string.equals("appointmentapproval")){
			final Appointment appointment= (Appointment) object;
			MimeMessagePreparator preparator = new MimeMessagePreparator() {

				public void prepare(MimeMessage mimeMessage) throws Exception {
					mimeMessage.setFrom("X_Appointment_System");
					mimeMessage.setRecipient(Message.RecipientType.TO,
							new InternetAddress(appointment.getEmail()));
					mimeMessage.setText("Your appointment have been APPROVED!! on: \n" +"Time : "+appointment.getTime()+":"+appointment.getTimeMM()+"\n Date :"+ appointment.getDate());
					mimeMessage.setSubject("Appointment Registration");
				}
			};
			return preparator;
		}
		if (string.equals("appointmentrejected")){
			final Appointment appointment= (Appointment) object;
			MimeMessagePreparator preparator = new MimeMessagePreparator() {

				public void prepare(MimeMessage mimeMessage) throws Exception {
					mimeMessage.setFrom("X_Appointment_System");
					mimeMessage.setRecipient(Message.RecipientType.TO,
							new InternetAddress(appointment.getEmail()));
					mimeMessage.setText("Sorry! Your appointment have been rejected because of STRICT SCHEDULE of respective Doctor!! \n" );
					mimeMessage.setSubject("Appointment Registration");
				}
			};
			return preparator;
		}
		return null;
	}
}

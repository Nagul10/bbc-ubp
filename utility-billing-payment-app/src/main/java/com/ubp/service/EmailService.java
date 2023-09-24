package com.ubp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	private final JavaMailSender javaMailSender;
	@Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendOtpEmail(String toEmail, long otp) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject("Your OTP Code");
        mailMessage.setText("Your OTP code is: " + otp);
        javaMailSender.send(mailMessage);
    }

}

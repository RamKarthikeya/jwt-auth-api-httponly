package com.example.auth.service; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired 
    private JavaMailSender mailSender;

    public void sendWelcomeEmail(String to, String name) throws MessagingException {
        if (mailSender == null) {
            throw new MessagingException("Mail sender is not configured!");
        }

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("k56159942@gmail.com");  
        helper.setTo(to);
        helper.setSubject("Welcome to Our Application!");
        helper.setText("Dear " + name + ",\n\nWelcome to our application! We're glad to have you on board.");

        mailSender.send(message);
    }
}

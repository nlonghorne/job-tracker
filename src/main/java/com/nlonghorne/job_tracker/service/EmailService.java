package com.nlonghorne.job_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendReminder(String email, String companyName, LocalDate followUpDate) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Follow-Up Reminder: " + companyName);
        message.setText("Just a reminder to follow up on your application to " + companyName + " today (" + followUpDate + "). Good luck!");
        mailSender.send(message);
    }
}

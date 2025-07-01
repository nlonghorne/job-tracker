package com.nlonghorne.job_tracker.service;

import com.nlonghorne.job_tracker.entity.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderScheduler {
    @Autowired
    private JobApplicationService jobService;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 12 * * *")
    public void sendDailyReminders() {
        List<JobApplication> todaysFollowUps = jobService.getFollowUpsForToday();
        for (JobApplication app : todaysFollowUps) {
            emailService.sendReminder("nlonghorne@gmail.com", app.getCompanyName(), app.getFollowUpDate());
        }
    }
}

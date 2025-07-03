package com.nlonghorne.job_tracker.repository;

import com.nlonghorne.job_tracker.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JobApplicationRepository extends
        JpaRepository <JobApplication, Long> {
    List<JobApplication> findByFollowUpDate(LocalDate date);
    List<JobApplication> findByCompanyName(String companyName);
}

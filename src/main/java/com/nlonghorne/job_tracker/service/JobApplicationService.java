package com.nlonghorne.job_tracker.service;

import com.nlonghorne.job_tracker.entity.JobApplication;
import com.nlonghorne.job_tracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobApplicationService {
    private final JobApplicationRepository jobRepository;

    public JobApplicationService(JobApplicationRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    /**
     * Saves a JobApplication entity.
     * @param jobApplication the JobApplication to save
     * @return the saved JobApplication
     */
    public JobApplication saveJobApplication(JobApplication jobApplication) {
        jobApplication.setApplicationDate(LocalDate.now());
        return jobRepository.save(jobApplication);
    }

    /**
     * Fetches the list of all JobApplication entities.
     * @return a list of JobApplications
     */
    public List<JobApplication> getAll() {
        return jobRepository.findAll();
    }

    /**
     * Fetches the list of JobApplication entities with the same company name.
     * @return a list of JobApplications
     */
    public List<JobApplication> getAllByCompany(String companyName) {
        return jobRepository.findByCompanyName(companyName);
    }

    /**
     * Fetches the specific JobApplication based on id.
     * @param id the id JobApplication we want to fetch
     * @return the requested JobApplication
     */
    public JobApplication getById(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Job application not found"));
    }

    /**
     * Updates an existing JobApplication entity.
     * @param updatedJobApplication the JobApplication with updated information
     * @param id the ID of the JobApplication to update
     * @return the updated JobApplication
     */
    public JobApplication updateJobApplication(JobApplication updatedJobApplication, Long id) {
        JobApplication application = jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Application not found"));
        application.setNotes(updatedJobApplication.getNotes());
        application.setStatus(updatedJobApplication.getStatus());
        application.setFollowUpDate(updatedJobApplication.getFollowUpDate());
        return application;
    }

    /**
     * Deletes a JobApplication entity by its ID.
     * @param id the ID of the JobApplication to delete
     */
    public void deleteJobApplicationById(Long id) {
        jobRepository.deleteById(id);
    }

    /**
     * Fetches all JobApplication entities that have a followUpDate of today.
     * @return a list of JobApplications
     */
    public List<JobApplication> getFollowUpsForToday() {
        return jobRepository.findByFollowUpDate(LocalDate.now());
    }
}

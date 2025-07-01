package com.nlonghorne.job_tracker.controller;

import com.nlonghorne.job_tracker.dto.JobApplicationDto;
import com.nlonghorne.job_tracker.entity.JobApplication;
import com.nlonghorne.job_tracker.service.FileStorageService;
import com.nlonghorne.job_tracker.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobApplicationController {
    @Autowired
    JobApplicationService service;

    private final FileStorageService fileStorageService;

    public JobApplicationController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping
    public ResponseEntity<JobApplication> saveJobApplication(@RequestBody JobApplication application) {
        JobApplication newApplication = service.saveJobApplication(application);
        return ResponseEntity.status(201).body(newApplication);
    }

    @PostMapping("/upload-resume")
    public ResponseEntity<String> uploadResume(@RequestParam("file") MultipartFile file) {
        try {
            String path = fileStorageService.storeFile(file);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
        }
    }

    @GetMapping
    public List<JobApplication> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getById(Long id) {
        return ResponseEntity.status(201).body(service.getById(id));
    }

    @GetMapping("/{companyName}")
    public List<JobApplication> getByCompanyName(String companyName) {
        return service.getAllByCompany(companyName);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> update(JobApplication application, Long id) {
        JobApplication updatedApplication = service.updateJobApplication(application, id);
        return ResponseEntity.status(201).body(updatedApplication);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        service.deleteJobApplicationById(id);
    }
}

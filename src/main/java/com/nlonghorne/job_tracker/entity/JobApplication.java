package com.nlonghorne.job_tracker.entity;

import com.nlonghorne.job_tracker.enums.JobStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplication {
    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    private String jobTitle;
    private JobStatus status;
    private LocalDate applicationDate;
    private String jobLink;
    private String resumePath;
    private String notes;
    private LocalDate followUpDate;
}


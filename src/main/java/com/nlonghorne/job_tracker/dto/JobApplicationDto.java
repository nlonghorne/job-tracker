package com.nlonghorne.job_tracker.dto;

import com.nlonghorne.job_tracker.enums.JobStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplicationDto {
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

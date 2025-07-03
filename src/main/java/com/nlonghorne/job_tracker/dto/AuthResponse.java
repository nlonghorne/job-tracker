package main.java.com.nlonghorne.job_tracker.dto;

import com.nlonghorne.job_tracker.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private User user;
}


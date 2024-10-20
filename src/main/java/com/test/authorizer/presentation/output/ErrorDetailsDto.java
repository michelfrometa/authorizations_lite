package com.test.authorizer.presentation.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ErrorDetailsDto {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private HttpStatus status;

    public ErrorDetailsDto(HttpStatus status, String message, String details) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
        this.status = status;
    }
}

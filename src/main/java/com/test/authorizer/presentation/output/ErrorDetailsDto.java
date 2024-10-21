package com.test.authorizer.presentation.output;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ErrorDetailsDto {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private String details;
    private HttpStatus status;
}

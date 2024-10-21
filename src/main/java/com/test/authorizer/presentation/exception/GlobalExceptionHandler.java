package com.test.authorizer.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.test.authorizer.presentation.output.ErrorDetailsDto;
import com.test.authorizer.presentation.output.ResponseDto; // FIXME Breaks The Dependency Rule of Clean Code

import java.util.Collections;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto<ErrorDetailsDto>> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(new ResponseDto<>(false, errorDetails, Collections.singletonList("Internal server error")), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

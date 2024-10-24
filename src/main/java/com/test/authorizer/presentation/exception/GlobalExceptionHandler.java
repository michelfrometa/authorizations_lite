package com.test.authorizer.presentation.exception;

import com.test.authorizer.application.exceptions.InvalidEntityException;
import com.test.authorizer.presentation.output.ErrorDetailsDto;
import com.test.authorizer.presentation.output.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto<ErrorDetailsDto>> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDetailsDto errorDetails = buildErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(new ResponseDto<>(false, errorDetails, Collections.singletonList("Internal server error")), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ResponseDto<ErrorDetailsDto>> handleInvalidEntityException(InvalidEntityException ex, WebRequest request) {
        ErrorDetailsDto errorDetails = buildErrorDetails(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(new ResponseDto<>(false, errorDetails, Collections.singletonList(ex.getValidationError().name())), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private ErrorDetailsDto buildErrorDetails(HttpStatus status, String message, String details) {
        return ErrorDetailsDto.builder()
                .message(message)
                .status(status)
                .details(details)
                .build();
    }
}

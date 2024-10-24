package com.test.authorizer.presentation.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.test.authorizer.application.exceptions.InvalidEntityException;
import com.test.authorizer.presentation.output.ErrorDetailsDto;
import com.test.authorizer.presentation.output.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ResponseDto<ErrorDetailsDto>> handleInvalidFormatException(InvalidFormatException ex, WebRequest request) {
        ErrorDetailsDto errorDetails = buildErrorDetails(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(new ResponseDto<>(false, errorDetails, Collections.singletonList(ex.getMessage())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ResponseDto<ErrorDetailsDto>> handleInvalidEntityException(InvalidEntityException ex, WebRequest request) {
        ErrorDetailsDto errorDetails = buildErrorDetails(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(new ResponseDto<>(false, errorDetails, Collections.singletonList(ex.getValidationError().name())), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ResponseDto<ErrorDetailsDto>> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {
        ErrorDetailsDto errorDetails = buildErrorDetails(HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(new ResponseDto<>(false, errorDetails, Collections.singletonList(ex.getMessage())), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto<ErrorDetailsDto>> handleGlobalException(Exception ex, WebRequest request) {
        Throwable cause = ex.getCause();

        if (cause instanceof InvalidFormatException invalidFormatException)
            return handleInvalidFormatException(invalidFormatException, request);

        ErrorDetailsDto errorDetails = buildErrorDetails(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(new ResponseDto<>(false, errorDetails, Collections.singletonList(ex.getMessage())), HttpStatus.UNPROCESSABLE_ENTITY);

    }

    private ErrorDetailsDto buildErrorDetails(HttpStatus status, String message, String details) {
        return ErrorDetailsDto.builder()
                .message(message)
                .status(status)
                .details(details)
                .build();
    }
}

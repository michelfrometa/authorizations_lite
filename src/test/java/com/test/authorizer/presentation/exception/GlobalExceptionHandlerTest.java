package com.test.authorizer.presentation.exception;
// GlobalExceptionHandlerTest.java

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import com.test.authorizer.presentation.output.ErrorDetailsDto;
import com.test.authorizer.presentation.output.ResponseDto;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    @Mock
    private WebRequest request;

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    void testHandleGlobalException() {
        // Arrange
        Exception ex = new RuntimeException("Test exception message");
        when(request.getDescription(false)).thenReturn("Test request description");

        // Act
        ResponseEntity<ResponseDto<ErrorDetailsDto>> response = globalExceptionHandler.handleGlobalException(ex,
                request);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

        ResponseDto<ErrorDetailsDto> responseBody = response.getBody();
        assertNotNull(responseBody);

        ErrorDetailsDto errorDetails = (ErrorDetailsDto) responseBody.getData();
        assertNotNull(errorDetails);
        assertEquals(ex.getMessage(), errorDetails.getMessage());
        assertEquals(request.getDescription(false), errorDetails.getDetails());
    }

}
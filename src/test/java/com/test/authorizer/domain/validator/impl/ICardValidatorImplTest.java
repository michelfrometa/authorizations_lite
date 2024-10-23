package com.test.authorizer.domain.validator.impl;

import com.test.authorizer.application.input.card.CreateCardDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ICardValidatorImplTest {

    private ICardValidatorImpl iCardValidator;

    @Mock
    private CreateCardDto createCardDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        iCardValidator = new ICardValidatorImpl();
    }

    @Test
    void validate_validInput_returnsSameInput() {
        // Arrange
        String expectedNumber = "1234567890";
        String expectedPassword = "password";
        when(createCardDto.getNumber()).thenReturn(expectedNumber);
        when(createCardDto.getPassword()).thenReturn(expectedPassword);

        // Act
        CreateCardDto result = iCardValidator.validate(createCardDto);

        // Assert
        assertEquals(expectedNumber, result.getNumber());
        assertEquals(expectedPassword, result.getPassword());
    }
}
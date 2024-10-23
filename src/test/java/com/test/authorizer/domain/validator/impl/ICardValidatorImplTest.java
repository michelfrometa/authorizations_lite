package com.test.authorizer.domain.validator.impl;

import com.test.authorizer.application.input.card.CreateCardDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ICardValidatorImplTest {

    @Mock
    private CreateCardDto createCardDto;

    @InjectMocks
    private ICardValidatorImpl iCardValidator;

    @Test
    void validate_validInput_returnsSameInput() {
        // Fixme Implement othe tests
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
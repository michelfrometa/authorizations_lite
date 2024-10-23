package com.test.authorizer.domain.validator.impl;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UpdateUserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class UserValidatorTest {

    @InjectMocks
    private UserValidator userValidator;

    @Test
    void testValidate_CreateUserDto_ValidInput_ReturnsDto() {
        // Arrange
        CreateUserDto createUserDto = CreateUserDto.builder().username("username").password("password").build();

        // Act
        CreateUserDto result = userValidator.validate(createUserDto);

        // Assert
        assertEquals(createUserDto, result);
    }

    @Test
    void testValidate_CreateUserDto_InvalidInput_ReturnsNull() {
        // Arrange
        CreateUserDto createUserDto = CreateUserDto.builder().username(null).password("password").build();

        // Act
        CreateUserDto result = userValidator.validate(createUserDto);

        // Assert
        assertNull(result);
    }

    @Test
    void testValidate_UpdateUserDto_ValidInput_ReturnsDto() {
        // Arrange
        UpdateUserDto updateUserDto = UpdateUserDto.builder().password("password").build();

        // Act
        UpdateUserDto result = userValidator.validate(updateUserDto);

        // Assert
        assertEquals(updateUserDto, result);
    }

    @Test
    void testValidate_UpdateUserDto_InvalidInput_ReturnsNull() {
        // Arrange
        UpdateUserDto updateUserDto = UpdateUserDto.builder().build();

        // Act
        UpdateUserDto result = userValidator.validate(updateUserDto);

        // Assert
        assertNull(result);
    }
}
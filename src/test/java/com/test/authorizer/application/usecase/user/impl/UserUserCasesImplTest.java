package com.test.authorizer.application.usecase.user.impl;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UserDto;
import com.test.authorizer.application.usecase.user.create.ICreateUserUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserUserCasesImplTest {

    @Mock
    private ICreateUserUseCase createUserUseCase;

    @InjectMocks
    private UserUserCasesImpl userUserCasesImpl;

    private CreateUserDto createUserDto;

    @BeforeEach
    void setup() {
        createUserDto = new CreateUserDto();
    }

    @Test
    void testCreateUser() {
        // Arrange
        UserDto expectedUserDto = new UserDto();
        when(createUserUseCase.execute(createUserDto)).thenReturn(expectedUserDto);

        // Act
        UserDto actualUserDto = userUserCasesImpl.create(createUserDto);

        // Assert
        assertEquals(expectedUserDto, actualUserDto);
    }

    @Test
    void testCreateUser_NullDto() {
        // Act and Assert
        assertNull(userUserCasesImpl.create(null));
    }
}
package com.test.authorizer.application.usecase.user.create.impl;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UserDto;
import com.test.authorizer.application.usecase.user.mapper.IUserMapper;
import com.test.authorizer.domain.model.User;
import com.test.authorizer.domain.repository.IUserRepository;
import com.test.authorizer.domain.validator.IUserValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateUserUseCaseTest {

    @Mock
    private IUserRepository repository;

    @Mock
    private IUserMapper mapper;

    @Mock
    private IUserValidator validator;

    @InjectMocks
    private CreateUserUseCase createUserUseCase;

    private CreateUserDto inputDto;
    private User user;
    private UserDto outputDto;

    @BeforeEach
    public void setup() {
        inputDto = CreateUserDto.builder().username("username").password("password").build();
        user = User.builder().id(1L).username("username").password("password").build();
        outputDto = UserDto.builder().id(1L).name("name").username("username").password("password").build();
    }

    @Test
    public void testExecute_ValidInput_ReturnsUserDto() {
        // Arrange
        when(validator.validate(inputDto)).thenReturn(inputDto);
        when(mapper.toEntity(inputDto)).thenReturn(user);
        when(repository.save(user)).thenReturn(user);
        when(mapper.toDto(user)).thenReturn(outputDto);

        // Act
        UserDto result = createUserUseCase.execute(inputDto);

        // Assert
        assertEquals(outputDto, result);
        verify(validator).validate(inputDto);
        verify(mapper).toEntity(inputDto);
        verify(repository).save(user);
        verify(mapper).toDto(user);
    }

    @Test
    public void testExecute_InvalidInput_ReturnsNull() {
        // Arrange
        when(validator.validate(inputDto)).thenReturn(null);

        // Act
        UserDto result = createUserUseCase.execute(inputDto);

        // Assert
        assertNull(result);
        verify(validator).validate(inputDto);
    }

    @Test
    public void testExecute_RepositorySaveReturnsNull_ReturnsNull() {
        // Arrange
        when(validator.validate(inputDto)).thenReturn(inputDto);
        when(mapper.toEntity(inputDto)).thenReturn(user);
        when(repository.save(user)).thenReturn(null);

        // Act
        UserDto result = createUserUseCase.execute(inputDto);

        // Assert
        assertNull(result);
        verify(validator).validate(inputDto);
        verify(mapper).toEntity(inputDto);
        verify(repository).save(user);
    }
}
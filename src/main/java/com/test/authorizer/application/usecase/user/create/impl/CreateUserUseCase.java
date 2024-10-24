package com.test.authorizer.application.usecase.user.create.impl;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UserDto;
import com.test.authorizer.application.usecase.user.create.ICreateUserUseCase;
import com.test.authorizer.application.usecase.user.mapper.IUserMapper;
import com.test.authorizer.domain.repository.IUserRepository;
import com.test.authorizer.domain.validator.user.IUserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CreateUserUseCase implements ICreateUserUseCase {
    private final IUserRepository repository;
    private final IUserMapper mapper;
    private final IUserValidator validator;

    @Override
    public UserDto execute(CreateUserDto inputDto) {
        return Optional.of(inputDto)
                .map(validator::validate)
                .map(mapper::toEntity)
                .map(repository::save)
                .map(mapper::toDto)
                .orElse(null);
    }
}

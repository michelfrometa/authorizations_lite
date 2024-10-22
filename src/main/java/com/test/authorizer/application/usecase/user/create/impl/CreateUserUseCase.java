package com.test.authorizer.application.usecase.user.create.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Optional;

import com.test.authorizer.application.input.CreateUserDto;
import com.test.authorizer.application.input.UserDto;
import com.test.authorizer.application.usecase.user.create.ICreateUserUseCase;
import com.test.authorizer.application.usecase.user.mapper.IUserMapper;
import com.test.authorizer.domain.repository.IUserRepository;
import com.test.authorizer.domain.validator.IUserValidator;
import com.test.authorizer.presentation.output.ResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.util.function.ThrowingFunction;

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

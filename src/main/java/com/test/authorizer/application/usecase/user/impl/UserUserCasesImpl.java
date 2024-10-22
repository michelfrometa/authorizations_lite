package com.test.authorizer.application.usecase.user.impl;

import org.springframework.stereotype.Service;

import com.test.authorizer.application.input.CreateUserDto;
import com.test.authorizer.application.input.UserDto;
import com.test.authorizer.application.usecase.user.IUserUserCases;
import com.test.authorizer.application.usecase.user.create.ICreateUserUseCase;
import com.test.authorizer.presentation.output.ResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserUserCasesImpl implements IUserUserCases {
    private final ICreateUserUseCase createUserUseCase;

    @Override
    public UserDto create(CreateUserDto dto) {
        return createUserUseCase.execute(dto);
    }
}

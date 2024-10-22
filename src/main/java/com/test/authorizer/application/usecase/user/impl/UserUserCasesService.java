package com.test.authorizer.application.usecase.user.impl;

import org.springframework.stereotype.Service;

import com.test.authorizer.application.input.CreateUserDto;
import com.test.authorizer.application.input.UserDto;
import com.test.authorizer.application.usecase.user.IUserUserCasesService;
import com.test.authorizer.application.usecase.user.create.ICreateUserUseCase;
import com.test.authorizer.presentation.output.ResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserUserCasesService implements IUserUserCasesService {
    private final ICreateUserUseCase createUserUseCase;

    @Override
    public ResponseDto<UserDto> create(CreateUserDto dto) {
        return createUserUseCase.execute(dto);
    }
}

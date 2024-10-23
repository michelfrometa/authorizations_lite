package com.test.authorizer.application.usecase.user.impl;

import com.test.authorizer.application.input.CreateUserDto;
import com.test.authorizer.application.input.UserDto;
import com.test.authorizer.application.usecase.user.IUserUserCases;
import com.test.authorizer.application.usecase.user.create.ICreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUserCasesImpl implements IUserUserCases {
    private final ICreateUserUseCase createUserUseCase;

    @Override
    public UserDto create(CreateUserDto dto) {
        return createUserUseCase.execute(dto);
    }
}

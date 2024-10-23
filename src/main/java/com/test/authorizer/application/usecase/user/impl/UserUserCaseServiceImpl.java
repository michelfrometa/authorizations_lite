package com.test.authorizer.application.usecase.user.impl;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UserDto;
import com.test.authorizer.application.usecase.user.IUserUserCaseService;
import com.test.authorizer.application.usecase.user.create.ICreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUserCaseServiceImpl implements IUserUserCaseService {
    private final ICreateUserUseCase createUserUseCase;

    @Override
    public UserDto create(CreateUserDto dto) {
        return createUserUseCase.execute(dto);
    }
}

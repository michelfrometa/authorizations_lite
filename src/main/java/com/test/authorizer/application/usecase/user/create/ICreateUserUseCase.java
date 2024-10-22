package com.test.authorizer.application.usecase.user.create;

import com.test.authorizer.application.input.CreateUserDto;
import com.test.authorizer.application.input.UserDto;
import com.test.authorizer.application.usecase.IUseCase;

public interface ICreateUserUseCase extends IUseCase<CreateUserDto, UserDto> {
}

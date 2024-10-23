package com.test.authorizer.application.usecase.user.create;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UserDto;
import com.test.authorizer.application.usecase.IUseCase;

public interface ICreateUserUseCase extends IUseCase<CreateUserDto, UserDto> {
}

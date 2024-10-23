package com.test.authorizer.application.usecase.user;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UserDto;

public interface IUserUseCaseService {

    UserDto create(CreateUserDto dto);

}

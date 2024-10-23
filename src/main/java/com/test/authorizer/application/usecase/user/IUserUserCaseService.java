package com.test.authorizer.application.usecase.user;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UserDto;

public interface IUserUserCaseService {

    UserDto create(CreateUserDto dto);

}

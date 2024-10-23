package com.test.authorizer.domain.validator;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UpdateUserDto;

public interface IUserValidator {

    CreateUserDto validate(CreateUserDto dto);

    UpdateUserDto validate(UpdateUserDto dto);

}

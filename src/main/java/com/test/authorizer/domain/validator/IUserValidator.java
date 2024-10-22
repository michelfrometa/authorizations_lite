package com.test.authorizer.domain.validator;

import java.util.List;

import com.test.authorizer.application.input.CreateUserDto;
import com.test.authorizer.application.input.UpdateUserDto;

public interface IUserValidator {

    CreateUserDto validate(CreateUserDto dto);

    List<String> validate(UpdateUserDto dto);

}

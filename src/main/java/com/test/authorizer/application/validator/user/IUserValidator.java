package com.test.authorizer.application.validator.user;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UpdateUserDto;
import com.test.authorizer.application.validator.IValidator;

public interface IUserValidator extends IValidator<CreateUserDto> {

    UpdateUserDto validate(UpdateUserDto dto);

}

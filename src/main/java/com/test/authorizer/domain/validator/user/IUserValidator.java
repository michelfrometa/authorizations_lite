package com.test.authorizer.domain.validator.user;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UpdateUserDto;
import com.test.authorizer.domain.validator.IValidator;

public interface IUserValidator extends IValidator<CreateUserDto> {

    UpdateUserDto validate(UpdateUserDto dto);

}

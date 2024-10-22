package com.test.authorizer.application.usecase.user;

import com.test.authorizer.application.input.CreateUserDto;
import com.test.authorizer.application.input.UserDto;
import com.test.authorizer.presentation.output.ResponseDto;

public interface IUserUserCasesService {

    ResponseDto<UserDto> create(CreateUserDto dto);

}

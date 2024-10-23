package com.test.authorizer.domain.validator.impl;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UpdateUserDto;
import com.test.authorizer.domain.validator.IUserValidator;
import org.springframework.stereotype.Service;

@Service
public class IUserValidatorImpl implements IUserValidator {

    @Override
    public CreateUserDto validate(CreateUserDto dto) {
        // TODO: Add validation rules
        return dto;
    }

    @Override
    public UpdateUserDto validate(UpdateUserDto dto) {
        // TODO: Add validation rules
        return dto;
    }

}

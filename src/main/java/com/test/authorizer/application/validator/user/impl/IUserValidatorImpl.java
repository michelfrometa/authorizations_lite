package com.test.authorizer.application.validator.user.impl;

import com.test.authorizer.application.input.user.UpdateUserDto;
import com.test.authorizer.application.validator.user.IUserValidator;
import org.springframework.stereotype.Service;

@Service
public class IUserValidatorImpl implements IUserValidator {

    @Override
    public UpdateUserDto validate(UpdateUserDto dto) {
        // TODO: Add validation rules
        return dto;
    }

}

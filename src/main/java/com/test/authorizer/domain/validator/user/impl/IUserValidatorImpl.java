package com.test.authorizer.domain.validator.user.impl;

import com.test.authorizer.application.input.user.UpdateUserDto;
import com.test.authorizer.domain.validator.user.IUserValidator;
import org.springframework.stereotype.Service;

@Service
public class IUserValidatorImpl implements IUserValidator {

    @Override
    public UpdateUserDto validate(UpdateUserDto dto) {
        // TODO: Add validation rules
        return dto;
    }

}

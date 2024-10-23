package com.test.authorizer.domain.validator.impl;

import java.util.Collections;
import java.util.List;

import com.test.authorizer.application.exceptions.InvalidEntityException;
import com.test.authorizer.application.input.CreateUserDto;
import com.test.authorizer.application.input.UpdateUserDto;
import com.test.authorizer.domain.validator.IUserValidator;
import org.springframework.stereotype.Service;

@Service
public class UserValidator implements IUserValidator {

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

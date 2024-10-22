package com.test.authorizer.domain.validator.impl;

import java.util.Collections;
import java.util.List;

import com.test.authorizer.application.input.CreateUserDto;
import com.test.authorizer.application.input.UpdateUserDto;
import com.test.authorizer.domain.validator.IUserValidator;
import org.springframework.stereotype.Service;

@Service
public class UserValidator implements IUserValidator {

    @Override
    public List<String> validate(CreateUserDto dto) {

        return Collections.emptyList();
    }

    @Override
    public List<String> validate(UpdateUserDto dto) {

        return Collections.emptyList();
    }

}

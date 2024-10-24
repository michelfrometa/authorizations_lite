package com.test.authorizer.application.usecase.card.create.impl;

import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.usecase.card.create.ICreateCardValidator;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import static com.test.authorizer.application.validator.VALIDATION_ERROR.ALREADY_EXISTS;

@Service
public class ICreateCardValidatorImpl implements ICreateCardValidator {

    @Override
    public CreateCardDto validate(CreateCardDto dto, boolean exists) {
        if (exists) {
            throw new NoSuchElementException(ALREADY_EXISTS.name());
        }

        return dto;
    }
}

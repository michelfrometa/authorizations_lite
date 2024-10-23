package com.test.authorizer.domain.validator.impl;

import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.domain.validator.ICardValidator;
import org.springframework.stereotype.Service;

@Service
public class ICardValidatorImpl implements ICardValidator {
    @Override
    public CreateCardDto validate(CreateCardDto createCardDto) {
        // TODO: Add validation rules
        return createCardDto;
    }
}

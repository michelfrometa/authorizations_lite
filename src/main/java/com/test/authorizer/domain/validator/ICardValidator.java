package com.test.authorizer.domain.validator;

import com.test.authorizer.application.input.card.CreateCardDto;

public interface ICardValidator {
    CreateCardDto validate(CreateCardDto createCardDto);
}

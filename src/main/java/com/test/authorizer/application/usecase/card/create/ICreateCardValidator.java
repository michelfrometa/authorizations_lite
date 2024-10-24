package com.test.authorizer.application.usecase.card.create;

import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.validator.IValidator;

public interface ICreateCardValidator extends IValidator<CreateCardDto> {

    CreateCardDto validate(CreateCardDto dto, boolean exists);
}

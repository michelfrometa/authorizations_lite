package com.test.authorizer.application.usecase.card.create;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.usecase.IUseCase;

public interface ICreateCardUseCase extends IUseCase<CreateCardDto, CardDto> {
}

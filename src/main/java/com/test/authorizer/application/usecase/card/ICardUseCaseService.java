package com.test.authorizer.application.usecase.card;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;

public interface ICardUseCaseService {

    CardDto create(CreateCardDto dto);
}


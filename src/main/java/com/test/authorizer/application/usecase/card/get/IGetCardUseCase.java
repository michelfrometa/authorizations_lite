package com.test.authorizer.application.usecase.card.get;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.IUseCase;

import java.util.List;

public interface IGetCardUseCase extends IUseCase<GetCardDto, List<CardDto>> {
}

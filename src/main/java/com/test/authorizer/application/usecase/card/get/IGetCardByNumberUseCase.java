package com.test.authorizer.application.usecase.card.get;

import com.test.authorizer.application.input.card.CardBalanceOnlyDto;
import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.IUseCase;

public interface IGetCardByNumberUseCase extends IUseCase<GetCardDto, CardBalanceOnlyDto> {
}

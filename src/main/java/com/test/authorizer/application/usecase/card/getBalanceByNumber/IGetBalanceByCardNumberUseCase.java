package com.test.authorizer.application.usecase.card.getBalanceByNumber;

import com.test.authorizer.application.input.card.CardBalanceOnlyDto;
import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.IUseCase;

public interface IGetBalanceByCardNumberUseCase extends IUseCase<GetCardDto, CardBalanceOnlyDto> {
}

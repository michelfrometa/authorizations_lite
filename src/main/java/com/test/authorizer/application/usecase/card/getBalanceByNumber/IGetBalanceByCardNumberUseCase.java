package com.test.authorizer.application.usecase.card.getBalanceByNumber;

import com.test.authorizer.application.input.card.CardBalanceOnlyDto;
import com.test.authorizer.application.input.card.CardNumberOnlyDto;
import com.test.authorizer.application.usecase.IUseCase;

public interface IGetBalanceByCardNumberUseCase extends IUseCase<CardNumberOnlyDto, CardBalanceOnlyDto> {
}

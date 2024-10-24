package com.test.authorizer.application.usecase.card.impl;

import com.test.authorizer.application.input.card.CardBalanceOnlyDto;
import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.card.ICardUseCase;
import com.test.authorizer.application.usecase.card.create.ICreateCardUseCase;
import com.test.authorizer.application.usecase.card.get.IGetCardUseCase;
import com.test.authorizer.application.usecase.card.getBalanceByNumber.IGetBalanceByCardNumberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ICardUseCaseImpl implements ICardUseCase {
    private final ICreateCardUseCase createCardUseCase;
    private final IGetCardUseCase getCardUseCase;
    private final IGetBalanceByCardNumberUseCase getBalanceByCardNumberUseCase;

    @Override
    public CardDto create(CreateCardDto createCardDto) {
        return createCardUseCase.execute(createCardDto);
    }

    @Override
    public List<CardDto> findAll(GetCardDto getCardDto) {
        return getCardUseCase.execute(getCardDto);
    }

    @Override
    public CardBalanceOnlyDto getBalanceByCardNumber(GetCardDto getCardDto) {
        return getBalanceByCardNumberUseCase.execute(getCardDto);
    }
}

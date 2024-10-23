package com.test.authorizer.application.usecase.card.impl;

import com.test.authorizer.application.input.card.CardBalanceOnlyDto;
import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.card.ICardUseCaseService;
import com.test.authorizer.application.usecase.card.create.ICreateCardUseCase;
import com.test.authorizer.application.usecase.card.get.IGetCardByNumberUseCase;
import com.test.authorizer.application.usecase.card.get.IGetCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ICardUseCaseServiceImpl implements ICardUseCaseService {
    private final ICreateCardUseCase createCardUseCase;
    private final IGetCardUseCase getCardUseCase;
    private final IGetCardByNumberUseCase getCardByNumberUseCase;

    @Override
    public CardDto create(CreateCardDto createCardDto) {
        return createCardUseCase.execute(createCardDto);
    }

    @Override
    public List<CardDto> findAll(GetCardDto getCardDto) {
        return getCardUseCase.execute(getCardDto);
    }

    @Override
    public CardBalanceOnlyDto getByNumber(GetCardDto getCardDto) {
        return getCardByNumberUseCase.execute(getCardDto);
    }
}

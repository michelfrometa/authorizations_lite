package com.test.authorizer.application.usecase.card.get.impl;

import com.test.authorizer.application.input.card.CardBalanceOnlyDto;
import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.card.get.IGetCardByNumberUseCase;
import com.test.authorizer.application.usecase.card.mapper.ICardMapper;
import com.test.authorizer.domain.repository.ICardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IGetCardByNumberUseCaseImpl implements IGetCardByNumberUseCase {
    private final ICardRepository iCardRepository;
    private final ICardMapper mapper;

    @Override
    public CardBalanceOnlyDto execute(GetCardDto getCardDto) {
        return Optional.of(getCardDto)
                .map(GetCardDto::getNumber)
                .flatMap(iCardRepository::getCardBalanceByNumber)
                .map(mapper::toDto)
                .orElse(null);
    }
}

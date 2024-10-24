package com.test.authorizer.application.usecase.card.getBalanceByNumber.impl;

import com.test.authorizer.application.input.card.CardBalanceOnlyDto;
import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.card.getBalanceByNumber.IGetBalanceByCardNumberUseCase;
import com.test.authorizer.application.usecase.card.getBalanceByNumber.IGetCardBalanceByNumberValidator;
import com.test.authorizer.application.usecase.card.mapper.ICardMapper;
import com.test.authorizer.domain.repository.ICardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IGetBalanceByCardNumberUseCaseImpl implements IGetBalanceByCardNumberUseCase {
    private final ICardRepository iCardRepository;
    private final ICardMapper mapper;
    private final IGetCardBalanceByNumberValidator validator;

    @Override
    public CardBalanceOnlyDto execute(GetCardDto getCardDto) {
        return Optional.of(getCardDto)
                .map(GetCardDto::getNumber)
                .map(iCardRepository::getCardBalanceByNumber)
                .map(validator::validate)
                .map(mapper::toDto)
                .orElse(null);
    }
}

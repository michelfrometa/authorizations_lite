package com.test.authorizer.application.usecase.card.get.impl;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.card.get.IGetCardUseCase;
import com.test.authorizer.application.usecase.card.mapper.ICardMapper;
import com.test.authorizer.domain.repository.ICardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetCardUseCaseImpl implements IGetCardUseCase {
    private final ICardRepository iCardRepository;
    private final ICardMapper iCardMapper;
    //private final IGetCardValidator iGetCardValidator;

    @Override
    public List<CardDto> execute(GetCardDto inputDto) {
        return Optional.of(inputDto)
                //.map(iGetCardValidator::validate) Fixme Nullpointer Exception
                .map(iCardRepository::findAll)
                .map(iCardMapper::toDto)
                .orElse(null);
    }
}

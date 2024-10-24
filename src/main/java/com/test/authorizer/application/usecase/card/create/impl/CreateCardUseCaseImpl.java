package com.test.authorizer.application.usecase.card.create.impl;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.usecase.card.create.ICreateCardUseCase;
import com.test.authorizer.application.usecase.card.mapper.ICardMapper;
import com.test.authorizer.domain.repository.ICardRepository;
import com.test.authorizer.domain.validator.card.ICardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CreateCardUseCaseImpl implements ICreateCardUseCase {
    private final ICardRepository repository;
    private final ICardMapper mapper;
    private final ICardValidator validator;

    @Override
    public CardDto execute(CreateCardDto inputDto) {
        return Optional.of(inputDto)
                .map(validator::validate)
                .map(mapper::toEntity)
                .map(card -> card.setBalance(500))
                .map(repository::save)
                .map(mapper::toDto)
                .orElse(null);
    }
}

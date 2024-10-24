package com.test.authorizer.application.usecase.card.create.impl;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.usecase.card.create.ICreateCardUseCase;
import com.test.authorizer.application.usecase.card.create.ICreateCardValidator;
import com.test.authorizer.application.usecase.card.mapper.ICardMapper;
import com.test.authorizer.domain.repository.ICardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CreateCardUseCaseImpl implements ICreateCardUseCase {
    private final ICardRepository iCardRepository;
    private final ICardMapper iCardMapper;
    private final ICreateCardValidator iCreateCardValidator;

    @Override
    public CardDto execute(CreateCardDto inputDto) {
        return Optional.of(inputDto)
                .map(target -> iCreateCardValidator.validate(target, iCardRepository.existsByNumberAndPassword(target.getNumber(), target.getPassword())))
                .map(iCardMapper::toEntity)
                .map(card -> card.setBalance(500))
                .map(iCardRepository::save)
                .map(iCardMapper::toDto)
                .orElse(null);
    }
}

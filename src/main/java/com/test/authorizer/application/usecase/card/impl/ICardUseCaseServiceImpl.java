package com.test.authorizer.application.usecase.card.impl;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.usecase.card.ICardUseCaseService;
import com.test.authorizer.application.usecase.card.create.ICreateCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ICardUseCaseServiceImpl implements ICardUseCaseService {
    private final ICreateCardUseCase createCardUseCase;

    @Override
    public CardDto create(CreateCardDto dto) {
        return createCardUseCase.execute(dto);
    }
}

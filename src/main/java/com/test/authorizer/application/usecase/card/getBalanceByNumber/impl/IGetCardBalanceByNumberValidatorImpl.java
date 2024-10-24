package com.test.authorizer.application.usecase.card.getBalanceByNumber.impl;

import com.test.authorizer.application.usecase.card.getBalanceByNumber.IGetCardBalanceByNumberValidator;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto.CardBalanceOnlyDto;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

import static com.test.authorizer.application.validator.VALIDATION_ERROR.INVALID_CARD;

@Service
public class IGetCardBalanceByNumberValidatorImpl implements IGetCardBalanceByNumberValidator {

    @Override
    public CardBalanceOnlyDto validate(Optional<CardBalanceOnlyDto> target) {
        return target
                .orElseThrow(() -> new NoSuchElementException(INVALID_CARD.name()));
    }
}

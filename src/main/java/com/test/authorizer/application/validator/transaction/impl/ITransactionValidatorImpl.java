package com.test.authorizer.application.validator.transaction.impl;

import com.test.authorizer.application.exceptions.InvalidEntityException;
import com.test.authorizer.application.input.transaction.CreateTransactionDto;
import com.test.authorizer.application.validator.transaction.ITransactionValidator;
import com.test.authorizer.domain.model.Card;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.test.authorizer.application.validator.VALIDATION_ERROR.INSUFFICIENT_BALANCE;
import static com.test.authorizer.application.validator.VALIDATION_ERROR.INVALID_CARD;
import static com.test.authorizer.application.validator.VALIDATION_ERROR.INVALID_PASSWORD;

@Service
public class ITransactionValidatorImpl implements ITransactionValidator {

    @Override
    public Card validate(CreateTransactionDto dto, Optional<Card> optionalCard) {
        return optionalCard
                .map(card -> {
                    if (dto.getAmount() > optionalCard.get().getBalance())
                        throw new InvalidEntityException(INSUFFICIENT_BALANCE);

                    if (!dto.getCardPassword().equals(card.getPassword()))
                        throw new InvalidEntityException(INVALID_PASSWORD);

                    return card;
                })
                .orElseThrow(() -> new InvalidEntityException(INVALID_CARD));
    }
}

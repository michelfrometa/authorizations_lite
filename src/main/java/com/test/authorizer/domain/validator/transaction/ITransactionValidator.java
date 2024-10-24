package com.test.authorizer.domain.validator.transaction;

import com.test.authorizer.application.input.transaction.CreateTransactionDto;
import com.test.authorizer.domain.model.Card;
import com.test.authorizer.domain.validator.IValidator;

import java.util.Optional;

public interface ITransactionValidator extends IValidator<CreateTransactionDto> {

    Card validate(CreateTransactionDto dto, Optional<Card> card);
}

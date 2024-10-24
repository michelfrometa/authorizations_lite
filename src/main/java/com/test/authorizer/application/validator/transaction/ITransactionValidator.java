package com.test.authorizer.application.validator.transaction;

import com.test.authorizer.application.input.transaction.CreateTransactionDto;
import com.test.authorizer.application.validator.IValidator;
import com.test.authorizer.domain.model.Card;

import java.util.Optional;

public interface ITransactionValidator extends IValidator<CreateTransactionDto> {

    Card validate(CreateTransactionDto dto, Optional<Card> card);
}

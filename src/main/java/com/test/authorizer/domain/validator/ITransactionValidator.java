package com.test.authorizer.domain.validator;

import com.test.authorizer.application.input.transaction.CreateTransactionDto;

public interface ITransactionValidator {
    CreateTransactionDto validate(CreateTransactionDto createCardDto);
}

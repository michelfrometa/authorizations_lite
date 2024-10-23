package com.test.authorizer.domain.validator.impl;

import com.test.authorizer.application.input.CreateTransactionDto;
import com.test.authorizer.domain.validator.ITransactionValidator;
import org.springframework.stereotype.Service;

@Service
public class ITransactionValidatorImpl implements ITransactionValidator {

    @Override
    public CreateTransactionDto validate(CreateTransactionDto createTransactionDto) {
        // TODO: Add validation rules
        return createTransactionDto;
    }
}

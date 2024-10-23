package com.test.authorizer.application.usecase.transaction.impl;

import com.test.authorizer.application.input.CreateTransactionDto;
import com.test.authorizer.application.input.TransactionDto;
import com.test.authorizer.application.usecase.transaction.ITransactionUseCaseService;
import com.test.authorizer.application.usecase.transaction.create.ICreateTransactionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionUseCaseServiceImpl implements ITransactionUseCaseService {
    private final ICreateTransactionUseCase createTransactionUseCase;

    @Override
    public TransactionDto create(CreateTransactionDto dto) {
        return createTransactionUseCase.execute(dto);
    }
}

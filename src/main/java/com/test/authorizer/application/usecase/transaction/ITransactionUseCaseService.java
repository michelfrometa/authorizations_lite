package com.test.authorizer.application.usecase.transaction;

import com.test.authorizer.application.input.transaction.CreateTransactionDto;
import com.test.authorizer.application.input.transaction.TransactionDto;

public interface ITransactionUseCaseService {

    TransactionDto create(CreateTransactionDto dto);

}

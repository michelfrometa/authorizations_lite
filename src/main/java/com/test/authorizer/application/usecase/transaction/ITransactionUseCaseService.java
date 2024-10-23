package com.test.authorizer.application.usecase.transaction;

import com.test.authorizer.application.input.CreateTransactionDto;
import com.test.authorizer.application.input.TransactionDto;

public interface ITransactionUseCaseService {

    TransactionDto create(CreateTransactionDto dto);

}

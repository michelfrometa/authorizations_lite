package com.test.authorizer.application.usecase.transaction.create;

import com.test.authorizer.application.input.transaction.CreateTransactionDto;
import com.test.authorizer.application.input.transaction.TransactionDto;
import com.test.authorizer.application.usecase.IUseCase;

public interface ICreateTransactionUseCase extends IUseCase<CreateTransactionDto, TransactionDto> {
}

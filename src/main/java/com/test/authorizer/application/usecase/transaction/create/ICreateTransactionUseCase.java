package com.test.authorizer.application.usecase.transaction.create;

import com.test.authorizer.application.input.CreateTransactionDto;
import com.test.authorizer.application.input.TransactionDto;
import com.test.authorizer.application.usecase.IUseCase;

public interface ICreateTransactionUseCase extends IUseCase<CreateTransactionDto, TransactionDto> {
}

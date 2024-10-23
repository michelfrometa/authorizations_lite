package com.test.authorizer.domain.repository;

import com.test.authorizer.domain.model.Transaction;

public interface ITransactionRepository {

    Transaction save(Transaction card);
}

package com.test.authorizer.infraestructure.persistence.mysql.repository.transaction;

import com.test.authorizer.domain.model.Transaction;
import com.test.authorizer.domain.repository.ITransactionRepository;
import com.test.authorizer.infraestructure.persistence.mysql.mapper.ITransactionMySqlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ITransactionRepositoryImpl implements ITransactionRepository {
    private final ITransactionRepositoryMysql iTransactionRepositoryMysql;
    private final ITransactionMySqlMapper iTransactionMySqlMapper;

    @Override
    public Transaction save(Transaction transaction) {
        return Optional.of(transaction)
                .map(iTransactionMySqlMapper::toPersistenceModel)
                .map(iTransactionRepositoryMysql::save)
                .map(iTransactionMySqlMapper::toEntity)
                .orElse(null);
    }
}

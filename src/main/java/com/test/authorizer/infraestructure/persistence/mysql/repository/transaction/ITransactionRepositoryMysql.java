package com.test.authorizer.infraestructure.persistence.mysql.repository.transaction;

import com.test.authorizer.infraestructure.persistence.mysql.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepositoryMysql extends JpaRepository<Transaction, Long> {
}

package com.test.authorizer.infraestructure.persistence.mysql.repository.card;

import com.test.authorizer.infraestructure.persistence.mysql.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface ICardRepositoryMysql extends JpaRepository<Card, Long> {
    Optional<Card> findByNumberAndPassword(BigInteger number, String password);
}

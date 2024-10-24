package com.test.authorizer.infraestructure.persistence.mysql.repository.card;

import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.infraestructure.persistence.mysql.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ICardRepositoryMysql extends JpaRepository<Card, Long>, ICardRepositoryMysqlCustom {
    Optional<Card> findByNumberAndPassword(BigInteger number, String password);

    List<Card> findAll(GetCardDto getCardDto);

    Optional<Card> findByNumber(BigInteger number);
}

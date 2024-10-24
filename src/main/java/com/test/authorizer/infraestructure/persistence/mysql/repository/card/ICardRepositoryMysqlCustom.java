package com.test.authorizer.infraestructure.persistence.mysql.repository.card;

import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.infraestructure.persistence.mysql.entity.Card;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto.CardBalanceOnlyDto;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ICardRepositoryMysqlCustom {

    List<Card> findAll(GetCardDto getCardDto);

    Optional<CardBalanceOnlyDto> getCardBalanceByNumber(BigInteger number);

    boolean existsByNumberAndPassword(BigInteger number, String password);
}

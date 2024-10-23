package com.test.authorizer.domain.repository;

import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.domain.model.Card;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto.CardBalanceOnlyDto;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ICardRepository {

    Card save(Card card);

    Optional<Card> findByNumberAndPassword(BigInteger number, String password);

    List<Card> findAll(GetCardDto getCardDto);

    Optional<CardBalanceOnlyDto> getCardBalanceByNumber(BigInteger number);

}

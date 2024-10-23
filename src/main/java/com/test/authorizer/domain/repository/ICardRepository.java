package com.test.authorizer.domain.repository;

import com.test.authorizer.domain.model.Card;

import java.math.BigInteger;
import java.util.Optional;

public interface ICardRepository {

    Card save(Card card);

    Optional<Card> findByNumberAndPassword(BigInteger number, String password);
}

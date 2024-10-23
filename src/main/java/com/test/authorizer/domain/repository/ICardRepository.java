package com.test.authorizer.domain.repository;

import com.test.authorizer.domain.model.Card;

public interface ICardRepository {

    Card save(Card card);
}

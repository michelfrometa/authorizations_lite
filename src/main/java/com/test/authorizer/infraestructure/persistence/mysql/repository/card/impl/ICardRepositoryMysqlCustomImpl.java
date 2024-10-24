package com.test.authorizer.infraestructure.persistence.mysql.repository.card.impl;

import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.infraestructure.persistence.mysql.entity.Card;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.ICardRepositoryMysqlCustom;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto.CardBalanceOnlyDto;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public class ICardRepositoryMysqlCustomImpl implements ICardRepositoryMysqlCustom {
    @Override
    public List<Card> findAll(GetCardDto getCardDto) {
        // TODO Implement
        return List.of();
    }

    @Override
    public Optional<CardBalanceOnlyDto> getCardBalanceByNumber(BigInteger number) {
        // TODO Implement
        return Optional.empty();
    }

    @Override
    public boolean existsByNumberAndPassword(BigInteger number, String password) {
        // TODO Implement
        return false;
    }
}

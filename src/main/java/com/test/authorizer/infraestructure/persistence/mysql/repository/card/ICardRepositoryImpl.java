package com.test.authorizer.infraestructure.persistence.mysql.repository.card;

import com.test.authorizer.domain.model.Card;
import com.test.authorizer.domain.repository.ICardRepository;
import com.test.authorizer.infraestructure.persistence.mysql.mapper.ICardMySqlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ICardRepositoryImpl implements ICardRepository {
    private final ICardRepositoryMysql iCardRepositoryMysql;
    private final ICardMySqlMapper mapper;

    @Override
    public Card save(Card card) {
        return Optional.of(card)
                .map(mapper::toPersistenceModel)
                .map(iCardRepositoryMysql::save)
                .map(mapper::toEntity)
                .orElse(null);
    }

    @Override
    public Optional<Card> findByNumberAndPassword(BigInteger number, String password) {
        return iCardRepositoryMysql.findByNumberAndPassword(number, password)
                .map(mapper::toEntity);
    }
}

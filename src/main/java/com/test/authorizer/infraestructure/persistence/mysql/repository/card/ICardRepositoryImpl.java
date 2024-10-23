package com.test.authorizer.infraestructure.persistence.mysql.repository.card;

import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.domain.model.Card;
import com.test.authorizer.domain.repository.ICardRepository;
import com.test.authorizer.infraestructure.persistence.mysql.mapper.ICardMySqlMapper;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto.CardBalanceOnlyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<Card> findAll(GetCardDto getCardDto) {
        return iCardRepositoryMysql.findAll(getCardDto).stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CardBalanceOnlyDto> getCardBalanceByNumber(BigInteger number) {
        return iCardRepositoryMysql.getCardBalanceByNumber(number);
    }
}

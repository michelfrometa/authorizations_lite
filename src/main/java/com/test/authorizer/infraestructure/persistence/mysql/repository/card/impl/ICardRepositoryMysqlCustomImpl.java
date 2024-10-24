package com.test.authorizer.infraestructure.persistence.mysql.repository.card.impl;

import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.infraestructure.persistence.mysql.entity.Card;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.ICardRepositoryMysqlCustom;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto.CardBalanceOnlyDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ICardRepositoryMysqlCustomImpl implements ICardRepositoryMysqlCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Card> findAll(GetCardDto getCardDto) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Card> cq = cb.createQuery(Card.class);
        Root<Card> card = cq.from(Card.class);

        List<Predicate> predicates = createPredicates(getCardDto, cb, card);
        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }

    private List<Predicate> createPredicates(GetCardDto getCardDto, CriteriaBuilder cb, Root<Card> card) {
        List<Predicate> predicates = new ArrayList<>();

        if (getCardDto.getNumber() != null) {
            predicates.add(cb.equal(card.get("number"), getCardDto.getNumber()));
        }

        if (getCardDto.getPassword() != null) {
            predicates.add(cb.equal(card.get("password"), getCardDto.getPassword()));
        }

        // Add more predicates for other fields in GetCardDto

        return predicates;
    }


    @Override
    public Optional<CardBalanceOnlyDto> getCardBalanceByNumber(BigInteger number) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CardBalanceOnlyDto> cq = cb.createQuery(CardBalanceOnlyDto.class);
        Root<Card> card = cq.from(Card.class);

        cq.select(cb.construct(CardBalanceOnlyDto.class, card.get("balance")));
        cq.where(cb.equal(card.get("number"), number));

        return entityManager.createQuery(cq).getResultList().stream().findFirst();

    }

    @Override
    public boolean existsByNumberAndPassword(BigInteger number, String password) {
        // TODO Implement
        return false;
    }
}

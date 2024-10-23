package com.test.authorizer.application.usecase.card;

import com.test.authorizer.application.input.card.CardBalanceOnlyDto;
import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.input.card.GetCardDto;

import java.util.List;

public interface ICardUseCaseService {

    /**
     * Creates a new card and returns it.
     *
     * @param dto the data transfer object containing the data of the card to be created
     * @return the created card
     */
    CardDto create(CreateCardDto dto);

    /**
     * Retrieves a list of cards based on the given filters.
     *
     * @param createTransactionDto the data transfer object containing the filters
     * @return a list of cards that match the filters
     */
    List<CardDto> findAll(GetCardDto createTransactionDto);

    /**
     * Retrieves a card by its card number.
     *
     * @param getCardDto the data transfer object containing the card number
     * @return the card with the given card number
     */
    CardBalanceOnlyDto getByNumber(GetCardDto getCardDto);
}


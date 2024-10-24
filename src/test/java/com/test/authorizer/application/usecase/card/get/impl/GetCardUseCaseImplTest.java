package com.test.authorizer.application.usecase.card.get.impl;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.card.mapper.ICardMapper;
import com.test.authorizer.domain.model.Card;
import com.test.authorizer.domain.repository.ICardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetCardUseCaseImplTest {

    @Mock
    private ICardRepository repository;

    @Mock
    private ICardMapper mapper;

    @InjectMocks
    private GetCardUseCaseImpl getCardUseCaseImpl;

    @Test
    void testExecute_ReturnsListOfWorkingCards() {
        // Arrange
        GetCardDto inputDto = new GetCardDto();
        List<Card> cards = List.of(new Card(), new Card());
        List<CardDto> cardDtos = List.of(new CardDto(), new CardDto());
        when(repository.findAll(any())).thenReturn(cards);
        when(mapper.toDto(anyList())).thenReturn(cardDtos);

        // Act
        List<CardDto> actualOutput = getCardUseCaseImpl.execute(inputDto);

        // Assert
        assertEquals(cardDtos, actualOutput);
    }

    @Test
    void testExecute_ReturnsEmptyList_WhenRepositoryReturnsEmptyList() {
        // Arrange
        CardDto dto = new CardDto();
        GetCardDto inputDto = new GetCardDto();
        List<Card> cards = List.of(new Card(), new Card());
        List<CardDto> cardDtos = List.of(new CardDto(), new CardDto());
        when(repository.findAll(any())).thenReturn(cards);
        when(mapper.toDto(anyList())).thenReturn(cardDtos);

        // Act
        List<CardDto> actualOutput = getCardUseCaseImpl.execute(inputDto);

        // Assert
        assertEquals(cardDtos, actualOutput);
    }

    @Test
    void testExecute_ReturnsNull_WhenRepositoryReturnsNull() {
        // Arrange
        GetCardDto inputDto = new GetCardDto();
        when(repository.findAll(any())).thenReturn(null);

        // Act
        List<CardDto> actualOutput = getCardUseCaseImpl.execute(inputDto);

        // Assert
        assertEquals(null, actualOutput);
    }
}
package com.test.authorizer.infraestructure.persistence.mysql.repository.card;

import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.infraestructure.persistence.mysql.entity.Card;
import com.test.authorizer.infraestructure.persistence.mysql.mapper.ICardMySqlMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ICardRepositoryImplTest {

    @Mock
    private ICardRepositoryMysql iCardRepositoryMysql;

    private final String PASSWORD = "PASSWORD";

    @InjectMocks
    private ICardRepositoryImpl iCardRepositoryImpl;
    private final BigInteger NUMBER = BigInteger.valueOf(123L);
    @Mock
    private ICardMySqlMapper iCardMySqlMapper;

    @Test
    public void testSave_CardSavedSuccessfully_ReturnsSavedCard() {
        // Arrange
        com.test.authorizer.domain.model.Card card = new com.test.authorizer.domain.model.Card();
        Card persistedCard = new Card();
        when(iCardMySqlMapper.toPersistenceModel(card)).thenReturn(persistedCard);
        when(iCardRepositoryMysql.save(persistedCard)).thenReturn(persistedCard);
        when(iCardMySqlMapper.toEntity(persistedCard)).thenReturn(card);

        // Act
        com.test.authorizer.domain.model.Card savedCard = iCardRepositoryImpl.save(card);

        // Assert
        assertEquals(card, savedCard);
    }

    @Test
    public void testSave_CardNotSaved_ReturnsNull() {
        // Arrange
        com.test.authorizer.domain.model.Card card = new com.test.authorizer.domain.model.Card();
        when(iCardMySqlMapper.toPersistenceModel(card)).thenReturn(null);

        // Act
        com.test.authorizer.domain.model.Card savedCard = iCardRepositoryImpl.save(card);

        // Assert
        assertNull(savedCard);
    }

    @Test
    public void findByNumberAndPassword_NumberAndPasswordNotNull_ReturnsCard() {
        // Arrange
        Card persistedCard = new Card();
        when(iCardRepositoryMysql.findByNumberAndPassword(NUMBER, PASSWORD)).thenReturn(Optional.of(persistedCard));

        // Act
        Optional<Card> result = iCardRepositoryMysql.findByNumberAndPassword(NUMBER, PASSWORD);

        // Assert
        assertEquals(Optional.of(persistedCard), result);
    }

    @Test
    public void findByNumberAndPassword_NumberNull_ReturnsEmptyOptional() {
        // Act
        Optional<Card> result = iCardRepositoryMysql.findByNumberAndPassword(null, PASSWORD);

        // Assert
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void findByNumberAndPassword_PasswordNull_ReturnsEmptyOptional() {
        // Act
        Optional<Card> result = iCardRepositoryMysql.findByNumberAndPassword(BigInteger.valueOf(123L), null);

        // Assert
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void findByNumberAndPassword_SaveReturnsEmptyOptional_ReturnsEmptyOptional() {
        // Arrange
        BigInteger NUMBER = BigInteger.valueOf(123L);

        when(iCardRepositoryMysql.findByNumberAndPassword(NUMBER, PASSWORD)).thenReturn(Optional.empty());

        // Act
        Optional<Card> result = iCardRepositoryMysql.findByNumberAndPassword(NUMBER, PASSWORD);

        // Assert
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void findAll_GetCardDtoNotNull_ReturnsCards() {
        // Arrange
        GetCardDto getCardDto = new GetCardDto();
        com.test.authorizer.domain.model.Card card = com.test.authorizer.domain.model.Card.builder().password(PASSWORD).build();
        Card persistedCard = Card.builder().password(PASSWORD).build();

        List<Card> persistedCardList = List.of(persistedCard);

        List<com.test.authorizer.domain.model.Card> cardList = List.of(card);

        when(iCardRepositoryMysql.findAll(getCardDto)).thenReturn(persistedCardList);


        // Act
        List<Card> result = iCardRepositoryMysql.findAll(getCardDto);

        // Assert
        assertEquals(persistedCardList, result);
    }

    @Test
    public void findAll_GetCardDtoNull_ReturnsEmptyList() {
        // Arrange
        GetCardDto getCardDto = null;

        // Act
        List<Card> result = iCardRepositoryMysql.findAll(getCardDto);

        // Assert
        assertEquals(List.of(), result);
    }

    @Test
    public void findAll_SaveReturnsEmptyList_ReturnsEmptyList() {
        // Arrange
        GetCardDto getCardDto = new GetCardDto();

        when(iCardRepositoryMysql.findAll(getCardDto)).thenReturn(List.of());

        // Act
        List<Card> result = iCardRepositoryMysql.findAll(getCardDto);

        // Assert
        assertEquals(List.of(), result);
    }
}
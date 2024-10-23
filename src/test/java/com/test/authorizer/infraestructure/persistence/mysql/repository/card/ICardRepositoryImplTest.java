package com.test.authorizer.infraestructure.persistence.mysql.repository.card;

import com.test.authorizer.domain.model.Card;
import com.test.authorizer.infraestructure.persistence.mysql.mapper.ICardMySqlMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ICardRepositoryImplTest {

    @Mock
    private ICardRepositoryMysql iCardRepositoryMysql;

    @Mock
    private ICardMySqlMapper mapper;

    @InjectMocks
    private ICardRepositoryImpl iCardRepositoryImpl;

    @Test
    public void testSave_CardSavedSuccessfully_ReturnsSavedCard() {
        // Arrange
        Card card = new Card();
        com.test.authorizer.infraestructure.persistence.mysql.entity.Card persistedCard = new com.test.authorizer.infraestructure.persistence.mysql.entity.Card();
        when(mapper.toPersistenceModel(card)).thenReturn(persistedCard);
        when(iCardRepositoryMysql.save(persistedCard)).thenReturn(persistedCard);
        when(mapper.toEntity(persistedCard)).thenReturn(card);

        // Act
        Card savedCard = iCardRepositoryImpl.save(card);

        // Assert
        assertEquals(card, savedCard);
    }

    @Test
    public void testSave_CardNotSaved_ReturnsNull() {
        // Arrange
        Card card = new Card();
        when(mapper.toPersistenceModel(card)).thenReturn(null);

        // Act
        Card savedCard = iCardRepositoryImpl.save(card);

        // Assert
        assertNull(savedCard);
    }
}
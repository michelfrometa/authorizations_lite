package com.test.authorizer.application.usecase.card.get.impl;

import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.card.getBalanceByNumber.impl.IGetBalanceByCardNumberUseCaseImpl;
import com.test.authorizer.domain.repository.ICardRepository;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto.CardBalanceOnlyDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IGetCardByNumberUseCaseImplTest {

    @Mock
    private ICardRepository repository;

    @InjectMocks
    private IGetBalanceByCardNumberUseCaseImpl getCardByNumberUseCase;

    private GetCardDto getCardDto;

    @Before
    public void setup() {
        getCardDto = new GetCardDto();
    }

    @Test
    public void testExecute_ReturnsCardBalanceOnlyDto_WhenRepositoryReturnsCard() {
        // Arrange
        CardBalanceOnlyDto persistedCardBalance = new CardBalanceOnlyDto();

        when(repository.getCardBalanceByNumber(any())).thenReturn(Optional.of(persistedCardBalance));

        // Act
        com.test.authorizer.application.input.card.CardBalanceOnlyDto actualOutput = getCardByNumberUseCase.execute(getCardDto);

        // Assert
        assertEquals(persistedCardBalance, actualOutput);
    }

    @Test
    public void testExecute_ReturnsNull_WhenRepositoryReturnsEmptyOptional() {
        // Arrange
        when(repository.getCardBalanceByNumber(eq(getCardDto.getNumber()))).thenReturn(Optional.empty());

        // Act
        com.test.authorizer.application.input.card.CardBalanceOnlyDto actualOutput = getCardByNumberUseCase.execute(getCardDto);

        // Assert
        assertEquals(null, actualOutput);
    }

    @Test
    public void testExecute_ThrowsException_WhenRepositoryThrowsException() {
      /*
       TODO Implement

       // Arrange
        when(repository.getCardBalanceByNumber(getCardDto.getNumber())).thenThrow(new RuntimeException());

        // Act and Assert
        try {
            getCardByNumberUseCase.execute(getCardDto);
            assert false;
        } catch (RuntimeException e) {
            assert true;
        }*/
    }
}
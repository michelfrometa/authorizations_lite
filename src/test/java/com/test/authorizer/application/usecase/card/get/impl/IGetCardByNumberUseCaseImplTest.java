package com.test.authorizer.application.usecase.card.get.impl;

import com.test.authorizer.application.input.card.CardNumberOnlyDto;
import com.test.authorizer.application.usecase.card.getBalanceByNumber.IGetCardBalanceByNumberValidator;
import com.test.authorizer.application.usecase.card.getBalanceByNumber.impl.IGetBalanceByCardNumberUseCaseImpl;
import com.test.authorizer.application.usecase.card.mapper.ICardMapper;
import com.test.authorizer.domain.repository.ICardRepository;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto.CardBalanceOnlyDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IGetCardByNumberUseCaseImplTest {

    @Mock
    private ICardRepository iCardRepository;
    @Mock
    private ICardMapper iCardMapper;
    @Mock
    private IGetCardBalanceByNumberValidator iGetCardBalanceByNumberValidator;

    @InjectMocks
    private IGetBalanceByCardNumberUseCaseImpl iGetBalanceByCardNumberUseCase;

    private CardNumberOnlyDto cardNumberOnlyDto;
    private CardBalanceOnlyDto cardBalanceOnlyDto;
    private com.test.authorizer.application.input.card.CardBalanceOnlyDto cardBalanceOnlyDtoResponse;

    @BeforeEach
    void setup() {
        cardNumberOnlyDto = CardNumberOnlyDto.builder().number(BigInteger.ONE).build();
        cardBalanceOnlyDto = CardBalanceOnlyDto.builder().balance(2000).build();
        cardBalanceOnlyDtoResponse = com.test.authorizer.application.input.card.CardBalanceOnlyDto.builder().balance(2000).build();
    }

    @Test
    public void testExecute_ReturnsCardBalanceOnlyDto_WhenRepositoryReturnsCard() {
        // Arrange
        CardBalanceOnlyDto persistedCardBalance = new CardBalanceOnlyDto();
        Optional<CardBalanceOnlyDto> optionalPersistedCardBalance = Optional.of(persistedCardBalance);

        when(iCardRepository.getCardBalanceByNumber(any(BigInteger.class))).thenReturn(optionalPersistedCardBalance);
        when(iGetCardBalanceByNumberValidator.validate(eq(optionalPersistedCardBalance))).thenReturn(cardBalanceOnlyDto);
        when(iCardMapper.toDto(any(CardBalanceOnlyDto.class))).thenReturn(cardBalanceOnlyDtoResponse);

        // Act
        com.test.authorizer.application.input.card.CardBalanceOnlyDto actualOutput = iGetBalanceByCardNumberUseCase.execute(cardNumberOnlyDto);

        // Assert
        Assertions.assertNotNull(actualOutput);
        assertEquals(actualOutput.getBalance(), cardBalanceOnlyDtoResponse.getBalance(), 0.1);
    }

    @Test
    public void testExecute_ReturnsNull_WhenRepositoryReturnsEmptyOptional() {
        // Arrange
        when(iCardRepository.getCardBalanceByNumber(any(BigInteger.class))).thenReturn(Optional.empty());

        // Act
        com.test.authorizer.application.input.card.CardBalanceOnlyDto actualOutput = iGetBalanceByCardNumberUseCase.execute(cardNumberOnlyDto);

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
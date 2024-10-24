package com.test.authorizer.application.usecase.transaction.create.impl;

import com.test.authorizer.application.input.transaction.CreateTransactionDto;
import com.test.authorizer.application.input.transaction.TransactionDto;
import com.test.authorizer.application.usecase.transaction.mapper.ITransactionMapper;
import com.test.authorizer.application.validator.transaction.ITransactionValidator;
import com.test.authorizer.domain.model.Card;
import com.test.authorizer.domain.model.Transaction;
import com.test.authorizer.domain.repository.ICardRepository;
import com.test.authorizer.domain.repository.ITransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateTransactionUseCaseTest {

    private final BigInteger CARD_NUMBER = new BigInteger("6549873025634501");
    private final String CARD_PASSWORD = "1234";
    private final double AMOUNT = 10.0F;
    private final long ID = 1L;
    @Mock
    private ITransactionRepository iTransactionRepository;
    @Mock
    private ICardRepository iCardRepository;
    @Mock
    private ITransactionMapper iTransactionMapper;
    @Mock
    private ITransactionValidator iTransactionValidator;
    @InjectMocks
    private CreateTransactionUseCase createTransactionUseCase;

    @Test
    public void testExecute_ValidInput_ReturnsTransactionDto() {
        // Arrange
        CreateTransactionDto createTransactionDto = CreateTransactionDto.builder().cardNumber(CARD_NUMBER).cardPassword(CARD_PASSWORD).amount(AMOUNT).build();
        Card card = Card.builder().number(CARD_NUMBER).password(CARD_PASSWORD).balance(100.0F).build();
        Optional<Card> optionalCard = Optional.of(card);
        Transaction transaction = Transaction.builder().card(card).amount(AMOUNT).build();
        TransactionDto transactionDto = TransactionDto.builder().id(ID).amount(AMOUNT).build();

        when(iCardRepository.findByNumber(any())).thenReturn(optionalCard);
        when(iTransactionMapper.toEntity(eq(createTransactionDto))).thenReturn(transaction);
        when(iTransactionRepository.save(eq(transaction))).thenReturn(transaction);
        when(iCardRepository.save(any())).thenReturn(card);
        when(iTransactionValidator.validate(eq(createTransactionDto), eq(optionalCard))).thenReturn(card);
        when(iTransactionMapper.toDto(eq(transaction))).thenReturn(transactionDto);

        // Act
        TransactionDto result = createTransactionUseCase.execute(createTransactionDto);

        // Assert
        assertNotNull(result);
        assertEquals(transaction.getAmount(), result.getAmount());
    }

    @Test
    public void testExecute_InvalidInput_ReturnsNull() {/*
    TODO IMPLEMENT

        // Arrange
        CreateTransactionDto createTransactionDto = CreateTransactionDto.builder().cardNumber(CARD_NUMBER).cardPassword("wrong-password").amount(AMOUNT).build();

        when(iCardRepository.findByNumberAndPassword(any(), any())).thenReturn(Optional.empty());
        when(iTransactionValidator.validate(eq(createTransactionDto))).thenReturn(createTransactionDto);

        // Act
        TransactionDto result = createTransactionUseCase.execute(createTransactionDto);

        // Assert
        assertEquals(null, result);*/
    }
}
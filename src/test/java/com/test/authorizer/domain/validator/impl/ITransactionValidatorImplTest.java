package com.test.authorizer.domain.validator.impl;

import com.test.authorizer.application.exceptions.InvalidEntityException;
import com.test.authorizer.application.input.transaction.CreateTransactionDto;
import com.test.authorizer.domain.model.Card;
import com.test.authorizer.domain.repository.ICardRepository;
import com.test.authorizer.domain.validator.transaction.impl.ITransactionValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.util.Optional;

import static com.test.authorizer.domain.validator.VALIDATION_ERROR.INSUFFICIENT_BALANCE;
import static com.test.authorizer.domain.validator.VALIDATION_ERROR.INVALID_CARD;
import static com.test.authorizer.domain.validator.VALIDATION_ERROR.INVALID_PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ITransactionValidatorImplTest {

    private final BigInteger CARD_NUMBER = new BigInteger("6549873025634501");
    private final String CARD_PASSWORD = "PASSWORD";
    @InjectMocks
    private ITransactionValidatorImpl transactionValidator;
    @Mock
    private ICardRepository cardRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidate_ValidCardAndAmount_ReturnsCard() {
        // Arrange
        CreateTransactionDto dto = new CreateTransactionDto();
        dto.setCardNumber(CARD_NUMBER);
        dto.setCardPassword(CARD_PASSWORD);
        dto.setAmount(100.0);

        Card card = new Card();
        card.setNumber(CARD_NUMBER);
        card.setPassword(CARD_PASSWORD);
        card.setBalance(200.0);

        Optional<Card> optionalCard = Optional.of(card);

        when(cardRepository.findByNumber(any())).thenReturn(optionalCard);

        // Act
        Card result = transactionValidator.validate(dto, optionalCard);

        // Assert
        assertEquals(card, result);
    }

    @Test
    public void testValidate_InvalidCard_ReturnsException() {
        // Arrange
        CreateTransactionDto dto = new CreateTransactionDto();
        dto.setCardNumber(CARD_NUMBER);
        dto.setCardPassword(CARD_PASSWORD);
        dto.setAmount(100.0);

        Optional<Card> optionalCard = Optional.empty();

        when(cardRepository.findByNumber(any())).thenReturn(optionalCard);

        // Act & Assert
        InvalidEntityException exception = assertThrows(InvalidEntityException.class, () -> transactionValidator.validate(dto, optionalCard));
        assertEquals(INVALID_CARD, exception.getValidationError());
    }

    @Test
    public void testValidate_InsufficientBalance_ReturnsException() {
        // Arrange
        CreateTransactionDto dto = new CreateTransactionDto();
        dto.setCardNumber(CARD_NUMBER);
        dto.setCardPassword(CARD_PASSWORD);
        dto.setAmount(300.0);

        Card card = new Card();
        card.setNumber(CARD_NUMBER);
        card.setPassword(CARD_PASSWORD);
        card.setBalance(200.0);

        Optional<Card> optionalCard = Optional.of(card);

        when(cardRepository.findByNumber(any())).thenReturn(optionalCard);

        // Act & Assert
        InvalidEntityException exception = assertThrows(InvalidEntityException.class, () -> transactionValidator.validate(dto, optionalCard));
        assertEquals(INSUFFICIENT_BALANCE, exception.getValidationError());
    }

    @Test
    public void testValidate_InvalidPassword_ReturnsException() {
        // Arrange
        CreateTransactionDto dto = new CreateTransactionDto();
        dto.setCardNumber(CARD_NUMBER);
        dto.setCardPassword("wrongpassword");
        dto.setAmount(100.0);

        Card card = new Card();
        card.setNumber(CARD_NUMBER);
        card.setPassword(CARD_PASSWORD);
        card.setBalance(200.0);

        Optional<Card> optionalCard = Optional.of(card);

        when(cardRepository.findByNumber(any())).thenReturn(optionalCard);

        // Act & Assert
        InvalidEntityException exception = assertThrows(InvalidEntityException.class, () -> transactionValidator.validate(dto, optionalCard));
        assertEquals(INVALID_PASSWORD, exception.getValidationError());
    }
}
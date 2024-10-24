package com.test.authorizer.application.usecase.card.getBalanceByNumber.impl;

import com.test.authorizer.application.exceptions.InvalidEntityException;
import com.test.authorizer.application.usecase.card.getBalanceByNumber.IGetCardBalanceByNumberValidator;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto.CardBalanceOnlyDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.test.authorizer.application.validator.VALIDATION_ERROR.INVALID_CARD;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IGetCardBalanceByNumberValidatorImplTest {

    @Mock
    private IGetCardBalanceByNumberValidator validator;

    @InjectMocks
    private IGetCardBalanceByNumberValidatorImpl validatorImpl;

    private CardBalanceOnlyDto cardBalanceOnlyDto;

    @Before
    public void setup() {
        cardBalanceOnlyDto = new CardBalanceOnlyDto();
    }

    @Test
    public void testValidate_ValidCardBalanceOnlyDto_ReturnsSameInstance() {
        // Arrange
        when(validator.validate(any(CardBalanceOnlyDto.class))).thenReturn(cardBalanceOnlyDto);

        // Act
        CardBalanceOnlyDto result = validatorImpl.validate(Optional.of(cardBalanceOnlyDto));

        // Assert
        assertEquals(cardBalanceOnlyDto, result);
    }

    @Test
    public void testValidate_InvalidCardBalanceOnlyDto_ThrowsInvalidEntityException() {
        // Arrange
        when(validator.validate(any(CardBalanceOnlyDto.class))).thenThrow(InvalidEntityException.class);


        // Act & Assert
        InvalidEntityException exception = Assertions.assertThrows(InvalidEntityException.class, () -> validatorImpl.validate(Optional.of(cardBalanceOnlyDto)));
        Assertions.assertEquals(INVALID_CARD, exception.getValidationError());
    }

    @Test
    public void testValidate_EmptyOptional_ReturnsNull() {
        // Act
        CardBalanceOnlyDto result = validatorImpl.validate(Optional.empty());

        // Assert
        assertEquals(null, result);
    }
}
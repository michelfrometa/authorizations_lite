package com.test.authorizer.application.usecase.card.getBalanceByNumber.impl;

import com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto.CardBalanceOnlyDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@ExtendWith(MockitoExtension.class)
public class IGetCardBalanceByNumberValidatorImplTest {

    @InjectMocks
    private IGetCardBalanceByNumberValidatorImpl iGetCardBalanceByNumberValidator1;

    private CardBalanceOnlyDto cardBalanceOnlyDto;

    @BeforeEach
    public void setup() {
        cardBalanceOnlyDto = new CardBalanceOnlyDto();
    }

    @Test
    public void testValidate_ValidCardBalanceOnlyDto_ReturnsSameInstance() {
        // Assert
        assertEquals(cardBalanceOnlyDto, iGetCardBalanceByNumberValidator1.validate(Optional.of(cardBalanceOnlyDto)));
    }

    @Test
    public void testValidate_EmptyOptional_ThrowsInvalidEntityException() {
        // Assert
        assertThrows(NoSuchElementException.class, () -> iGetCardBalanceByNumberValidator1.validate(Optional.empty()));
    }
}
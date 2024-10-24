package com.test.authorizer.application.usecase.card.create.impl;

import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.domain.repository.ICardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ICreateCardValidatorImplTest {

    private final BigInteger CARD_NUMBER = new BigInteger("6549873025634501");
    private final String CARD_PASSWORD = "PASSWORD";
    @Mock
    private ICardRepository iCardRepository;
    @InjectMocks
    private ICreateCardValidatorImpl iCreateCardValidator;
    private CreateCardDto createCardDto;

    @BeforeEach
    void setup() {
        createCardDto = CreateCardDto.builder().number(CARD_NUMBER).password(CARD_PASSWORD).build();
    }

    @Test
    void testValidate_CardAlreadyExists_ThrowsException() {
        // Act and Assert
        assertThrows(NoSuchElementException.class, () -> iCreateCardValidator.validate(createCardDto, true));
    }

    @Test
    void testValidate_CardDoesNotExist_ReturnsValid() {

        // Act and Assert
        CreateCardDto response = iCreateCardValidator.validate(createCardDto, false);

        assertEquals(createCardDto, response);


    }
}
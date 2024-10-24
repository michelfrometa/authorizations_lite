package com.test.authorizer.application.usecase.card.create.impl;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.usecase.card.create.ICreateCardValidator;
import com.test.authorizer.application.usecase.card.mapper.ICardMapper;
import com.test.authorizer.domain.model.Card;
import com.test.authorizer.domain.repository.ICardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCardUseCaseTest {

    @Mock
    private ICardRepository repository;

    @Mock
    private ICardMapper mapper;

    private final String PASSWORD = "PASSWORD";

    @InjectMocks
    private CreateCardUseCaseImpl CreateCardUseCaseImpl;
    private final BigInteger CARD_NUMBER = new BigInteger("6549873025634501");
    @Mock
    private ICreateCardValidator validator;

    @Test
    void execute_ValidInput_ReturnsCardDto() {
        // Arrange
        CreateCardDto inputDto = CreateCardDto.builder().number(CARD_NUMBER).password(PASSWORD).build();

        Card card = Card.builder().id(1L).number(CARD_NUMBER).password(PASSWORD).balance(500f).build();
        CardDto expectedOutput = new CardDto(1L, CARD_NUMBER, PASSWORD, 500f);

        when(mapper.toEntity(inputDto)).thenReturn(card);
        when(repository.save(card)).thenReturn(card);
        when(repository.existsByNumberAndPassword(eq(CARD_NUMBER), eq(PASSWORD))).thenReturn(true);
        when(validator.validate(any(CreateCardDto.class), anyBoolean())).thenReturn(inputDto);
        when(mapper.toDto(card)).thenReturn(expectedOutput);

        // Act
        CardDto output = CreateCardUseCaseImpl.execute(inputDto);

        // Assert
        assertEquals(expectedOutput, output);
        //verify(validator).validate(inputDto); Fixme Nullpointer Exception
        verify(mapper).toEntity(inputDto);
        verify(repository).save(card);
        verify(mapper).toDto(card);
    }

    @Test
    void execute_InvalidInput_ReturnsNull() {
        // Arrange
        CreateCardDto inputDto = CreateCardDto.builder().number(CARD_NUMBER).password(PASSWORD).build();

        when(repository.existsByNumberAndPassword(eq(CARD_NUMBER), eq(PASSWORD))).thenReturn(false);
        when(validator.validate(any(CreateCardDto.class), anyBoolean())).thenReturn(null);

        // Act
        CardDto output = CreateCardUseCaseImpl.execute(inputDto);

        // Assert
        assertNull(output);
        verify(validator).validate(inputDto, false);
    }
}
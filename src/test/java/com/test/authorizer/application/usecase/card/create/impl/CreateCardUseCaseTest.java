package com.test.authorizer.application.usecase.card.create.impl;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.usecase.card.mapper.ICardMapper;
import com.test.authorizer.domain.model.Card;
import com.test.authorizer.domain.repository.ICardRepository;
import com.test.authorizer.domain.validator.ICardValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCardUseCaseTest {

    @Mock
    private ICardRepository repository;

    @Mock
    private ICardMapper mapper;

    @Mock
    private ICardValidator validator;

    @InjectMocks
    private CreateCardUseCase createCardUseCase;

    @Test
    void execute_ValidInput_ReturnsCardDto() {
        // Arrange
        CreateCardDto inputDto = CreateCardDto.builder().number("1234567890").password("password").build();

        Card card = Card.builder().id(1L).number("1234567890").password("password").balance(500f).build();
        CardDto expectedOutput = new CardDto(1L, "1234567890", "password", 500f);

        when(validator.validate(any(CreateCardDto.class))).thenReturn(inputDto);
        when(mapper.toEntity(inputDto)).thenReturn(card);
        when(repository.save(card)).thenReturn(card);
        when(mapper.toDto(card)).thenReturn(expectedOutput);

        // Act
        CardDto output = createCardUseCase.execute(inputDto);

        // Assert
        assertEquals(expectedOutput, output);
        verify(validator).validate(inputDto);
        verify(mapper).toEntity(inputDto);
        verify(repository).save(card);
        verify(mapper).toDto(card);
    }

    @Test
    void execute_InvalidInput_ReturnsNull() {
        // Arrange
        CreateCardDto inputDto = new CreateCardDto("", "");

        when(validator.validate(any(CreateCardDto.class))).thenReturn(null);

        // Act
        CardDto output = createCardUseCase.execute(inputDto);

        // Assert
        assertNull(output);
        verify(validator).validate(inputDto);
    }
}
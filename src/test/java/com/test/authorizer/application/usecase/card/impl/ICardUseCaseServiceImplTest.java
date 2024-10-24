package com.test.authorizer.application.usecase.card.impl;


import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.card.create.ICreateCardUseCase;
import com.test.authorizer.application.usecase.card.get.IGetCardUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ICardUseCaseServiceImplTest {
    @Mock
    private ICreateCardUseCase createCardUseCase;
    @Mock
    private IGetCardUseCase getCardUseCase;

    @InjectMocks
    private ICardUseCaseImpl cardUseCaseService;

    @Test
    void testCreate() {
        // Arrange
        CreateCardDto inputDto = new CreateCardDto();
        CardDto expectedOutput = new CardDto();
        when(createCardUseCase.execute(inputDto)).thenReturn(expectedOutput);

        // Act
        CardDto output = cardUseCaseService.create(inputDto);

        // Assert
        assertEquals(expectedOutput, output);
    }


    @Test
    void testFindAll() {
        // Arrange
        GetCardDto getCardDto = new GetCardDto();
        List<CardDto> expectedOutput = List.of(new CardDto(), new CardDto());
        when(getCardUseCase.execute(getCardDto)).thenReturn(expectedOutput);

        // Act
        List<CardDto> actualOutput = cardUseCaseService.findAll(getCardDto);

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }
}
package com.test.authorizer.application.usecase.card.impl;


import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.usecase.card.create.ICreateCardUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ICardUseCaseServiceImplTest {
    @Mock
    private ICreateCardUseCase createCardUseCase;

    @InjectMocks
    private ICardUseCaseServiceImpl cardUseCaseService;

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
}
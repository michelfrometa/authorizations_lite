package com.test.authorizer.application.usecase.transaction.impl;

import com.test.authorizer.application.input.transaction.CreateTransactionDto;
import com.test.authorizer.application.input.transaction.TransactionDto;
import com.test.authorizer.application.usecase.transaction.create.ICreateTransactionUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionUseCaseServiceImplTest {

    @Mock
    private ICreateTransactionUseCase createTransactionUseCase;

    @InjectMocks
    private TransactionUseCaseServiceImpl transactionUseCaseService;

    @Test
    public void testCreate_ValidInput_ReturnsTransactionDto() {
        // Arrange
        CreateTransactionDto inputDto = new CreateTransactionDto();
        TransactionDto expectedOutput = new TransactionDto();

        when(createTransactionUseCase.execute(any(CreateTransactionDto.class))).thenReturn(expectedOutput);

        // Act
        TransactionDto output = transactionUseCaseService.create(inputDto);

        // Assert
        assertNotNull(output);
    }

    @Test
    public void testCreate_InvalidInput_ReturnsNull() {
        // Arrange
        CreateTransactionDto inputDto = new CreateTransactionDto();
        TransactionDto expectedOutput = null;

        when(createTransactionUseCase.execute(any(CreateTransactionDto.class))).thenReturn(expectedOutput);

        // Act
        TransactionDto output = transactionUseCaseService.create(inputDto);

        // Assert
        assertNull(output);
    }
}
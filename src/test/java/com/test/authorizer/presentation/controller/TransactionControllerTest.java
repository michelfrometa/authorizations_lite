package com.test.authorizer.presentation.controller;

import com.test.authorizer.application.usecase.transaction.ITransactionUseCaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

    @Mock
    private ITransactionUseCaseService iTransactionUseCaseService;

    @InjectMocks
    private TransactionController transactionController;

    @Test
    public void testCreate() {
    }

}
package com.test.authorizer.presentation.controller;

import com.test.authorizer.application.input.transaction.CreateTransactionDto;
import com.test.authorizer.application.input.transaction.TransactionDto;
import com.test.authorizer.application.usecase.transaction.ITransactionUseCaseService;
import com.test.authorizer.presentation.output.ResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/transacoes")
@RequiredArgsConstructor
public class TransactionController {

    private final ITransactionUseCaseService iTransactionUseCaseService;

    @PostMapping
    public ResponseEntity<ResponseDto<TransactionDto>> create(@RequestBody @Valid @NotNull CreateTransactionDto createTransactionDto) {
        return Optional.of(createTransactionDto)
                .map(iTransactionUseCaseService::create)
                .map(ResponseDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}

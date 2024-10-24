package com.test.authorizer.presentation.controller;

import com.test.authorizer.application.input.transaction.CreateTransactionDto;
import com.test.authorizer.application.input.transaction.TransactionDto;
import com.test.authorizer.application.usecase.transaction.ITransactionUseCaseService;
import com.test.authorizer.presentation.output.ResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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


    @PostMapping("/task")
    public ResponseEntity<String> createTask(@RequestBody @Valid @NotNull CreateTransactionDto createTransactionDto) {
        iTransactionUseCaseService.create(createTransactionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }

    @PostMapping
    public ResponseEntity<ResponseDto<TransactionDto>> create(@RequestBody @Valid @NotNull CreateTransactionDto createTransactionDto) {
        return Optional.of(createTransactionDto)
                .map(iTransactionUseCaseService::create)
                .map(ResponseDto::new)
                .map(responseDto -> ResponseEntity.status(HttpStatus.CREATED).body(responseDto)) // Fixme Use Location
                .orElse(ResponseEntity.badRequest().build());
    }
}

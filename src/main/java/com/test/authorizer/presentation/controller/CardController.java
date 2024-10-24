package com.test.authorizer.presentation.controller;

import com.test.authorizer.application.input.card.CardBalanceOnlyDto;
import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.card.ICardUseCase;
import com.test.authorizer.presentation.output.ResponseDto;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CardController {

    private final ICardUseCase iCardUseCase;

    @GetMapping
    public ResponseEntity<List<CardDto>> get(
            @RequestParam(required = false) BigInteger numeroCartao,
            @RequestParam(required = false) String senhaCartao,
            @RequestParam(required = false) Double saldo) {

        GetCardDto getCardDto = GetCardDto.builder()
                .number(numeroCartao)
                .password(senhaCartao)
                .balance(saldo)
                .build();

        return Optional.of(getCardDto)
                .map(iCardUseCase::findAll)
                .map(ResponseEntity::ok)
                .orElse(null);
    }

    @GetMapping("/{number}")
    // TODO Endpoint NOT Restfull
    public ResponseEntity<Double> getBalanceByCardNumber(
            @PathVariable @NotNull(message = "Numero de cartao requerido") BigInteger number) {

        return Optional.of(GetCardDto.builder().number(number).build())
                .map(iCardUseCase::getBalanceByCardNumber)
                .map(CardBalanceOnlyDto::getBalance)
                .map(ResponseEntity::ok)
                .orElse(null);
    }

    @PostMapping
    public ResponseEntity<ResponseDto<CardDto>> create(@RequestBody CreateCardDto dto) {
        return Optional.of(dto)
                .map(iCardUseCase::create)
                .map(ResponseDto::new)
                .map(ResponseEntity::ok)
                .orElse(null);
    }
}

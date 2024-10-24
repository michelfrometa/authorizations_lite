package com.test.authorizer.presentation.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.authorizer.application.input.card.CardBalanceOnlyDto;
import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.input.card.GetCardDto;
import com.test.authorizer.application.usecase.card.ICardUseCase;
import com.test.authorizer.presentation.output.ResponseDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<ResponseDto<List<CardDto>>> get(
            @RequestParam(required = false) @JsonProperty("numeroCartao") BigInteger cardNumber,
            @RequestParam(required = false) @JsonProperty("senhaCartao") String cardPassword,
            @RequestParam(required = false) @JsonProperty("saldo") double balance) {

        return Optional.of(GetCardDto.builder().number(cardNumber).password(cardPassword).balance(balance).build())
                .map(iCardUseCase::findAll)
                .map(ResponseDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/{number}")
    // TODO Endpoint NOT Restfull
    public ResponseEntity<ResponseDto<Double>> getBalanceByCardNumber(
            @PathVariable @NotEmpty(message = "Numero de cartao requerido") BigInteger number) {

        return Optional.of(GetCardDto.builder().number(number).build())
                .map(iCardUseCase::getBalanceByCardNumber)
                .map(CardBalanceOnlyDto::getBalance)
                .map(ResponseDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<ResponseDto<CardDto>> create(@ModelAttribute CreateCardDto dto) {
        return Optional.of(dto)
                .map(iCardUseCase::create)
                .map(ResponseDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}

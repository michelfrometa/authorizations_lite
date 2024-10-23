package com.test.authorizer.presentation.controller;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.usecase.card.ICardUseCaseService;
import com.test.authorizer.presentation.output.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CardController {

    private final ICardUseCaseService cardUseCaseService;

    @PostMapping
    public ResponseEntity<ResponseDto<CardDto>> saveAnalysisDocument(@ModelAttribute CreateCardDto dto) {
        return Optional.of(dto)
                .map(cardUseCaseService::create)
                .map(ResponseDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}

package com.test.authorizer.application.usecase.transaction.create.impl;

import com.test.authorizer.application.input.CreateTransactionDto;
import com.test.authorizer.application.input.TransactionDto;
import com.test.authorizer.application.usecase.transaction.create.ICreateTransactionUseCase;
import com.test.authorizer.application.usecase.transaction.mapper.ITransactionMapper;
import com.test.authorizer.domain.model.Transaction;
import com.test.authorizer.domain.repository.ICardRepository;
import com.test.authorizer.domain.repository.ITransactionRepository;
import com.test.authorizer.domain.validator.ITransactionValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CreateTransactionUseCase implements ICreateTransactionUseCase {
    private final ITransactionRepository iTransactionRepository;
    private final ICardRepository iCardRepository;
    private final ITransactionMapper iTransactionMapper;
    private final ITransactionValidator iTransactionValidator;

    @Override
    public TransactionDto execute(CreateTransactionDto inputDto) {
        return Optional.of(inputDto)
                .map(iTransactionValidator::validate)
                .flatMap(this::createTransaction)
                .map(iTransactionRepository::save)
                .map(iTransactionMapper::toDto)
                .orElse(null);
    }

    private Optional<Transaction> createTransaction(CreateTransactionDto createTransactionDto) {
        return iCardRepository.findByNumberAndPassword(createTransactionDto.getCardNumber(), createTransactionDto.getCardPassword())
                .map(card -> card.setBalance(card.getBalance() + createTransactionDto.getAmount()))
                .map(card -> iTransactionMapper.toEntity(createTransactionDto).setCard(card));
    }
}

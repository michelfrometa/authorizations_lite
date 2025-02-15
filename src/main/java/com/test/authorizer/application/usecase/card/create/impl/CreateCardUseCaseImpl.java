package com.test.authorizer.application.usecase.card.create.impl;

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.usecase.card.create.ICreateCardUseCase;
import com.test.authorizer.application.usecase.card.create.ICreateCardValidator;
import com.test.authorizer.application.usecase.card.mapper.ICardMapper;
import com.test.authorizer.domain.model.Card;
import com.test.authorizer.domain.repository.ICardRepository;
import com.test.authorizer.domain.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CreateCardUseCaseImpl implements ICreateCardUseCase {
    private final ICardRepository iCardRepository;
    private final IUserRepository iUserRepository;
    private final ICardMapper iCardMapper;
    private final ICreateCardValidator iCreateCardValidator;

    @Override
    public CardDto execute(CreateCardDto inputDto) {
        return Optional.of(inputDto)
                .map(target -> iCreateCardValidator.validate(target, iCardRepository.existsByNumberAndPassword(target.getNumber(), target.getPassword())))
                .map(iCardMapper::toEntity)
                .map(card -> card.setBalance(500D))
                .map(this::setUser)
                .map(iCardRepository::save)
                .map(iCardMapper::toDto)
                .orElse(null);
    }

    /**
     * Implementation of the {@link ICreateCardUseCase} interface.
     * This class is responsible for creating a new card.
     * <p>
     * It validates the card data, sets an initial balance, associates the card with a user,
     * saves the card in the repository, and converts it to a DTO.
     * </p>
     *
     * @see ICreateCardUseCase
     */
    private Card setUser(Card card) {
        Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .map(User.class::cast)
                .flatMap(user -> iUserRepository.findByUsername(user.getUsername()))
                .ifPresent(card::setUser);

        return card;
    }
}

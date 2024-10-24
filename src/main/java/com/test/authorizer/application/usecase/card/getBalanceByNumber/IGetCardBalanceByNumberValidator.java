package com.test.authorizer.application.usecase.card.getBalanceByNumber;

import com.test.authorizer.application.exceptions.InvalidEntityException;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.validator.IValidator;
import com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto.CardBalanceOnlyDto;

import java.util.Optional;

public interface IGetCardBalanceByNumberValidator extends IValidator<CardBalanceOnlyDto> {

    /**
     * Validates the given {@link CreateCardDto} for creation of a new
     * {@link com.test.authorizer.domain.model.Card}.
     *
     * @param target the {@link CreateCardDto} to be validated
     * @return the same instance of {@link CreateCardDto} if it is valid,
     * otherwise throws an exception
     * @throws InvalidEntityException if the given {@link CreateCardDto} is not valid
     */
    CardBalanceOnlyDto validate(Optional<CardBalanceOnlyDto> target);
}

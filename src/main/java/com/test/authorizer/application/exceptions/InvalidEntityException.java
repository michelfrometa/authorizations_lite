package com.test.authorizer.application.exceptions;

import com.test.authorizer.application.validator.VALIDATION_ERROR;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serial;

@Getter
@RequiredArgsConstructor
public class InvalidEntityException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7111215781378668614L;

    private final VALIDATION_ERROR validationError;
    ;

}

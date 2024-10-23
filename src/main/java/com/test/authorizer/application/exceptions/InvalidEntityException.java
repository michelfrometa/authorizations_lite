package com.test.authorizer.application.exceptions;

import java.io.Serial;

public class InvalidEntityException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7111215781378668614L;

    public InvalidEntityException(String message) {
        super(message);
    }

}

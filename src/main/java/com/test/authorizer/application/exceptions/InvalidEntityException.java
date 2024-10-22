package com.test.authorizer.application.exceptions;

import java.io.Serial;
import java.lang.reflect.UndeclaredThrowableException;

public class InvalidEntityException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7111215781378668614L;

    public InvalidEntityException(String message) {
        super(message);
    }
/*
    public InvalidEntityException(Throwable exception, String message) {
        super(message, exception);
        *//*super(e instanceof UndeclaredThrowableException || e instanceof InvalidEntityException
              ? e.getCause()
              : e);*//*
    }*/

}

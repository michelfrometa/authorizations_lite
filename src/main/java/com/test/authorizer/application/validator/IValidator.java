package com.test.authorizer.application.validator;

public interface IValidator<T> {
    /**
     * Validate the given object and return it if valid.
     *
     * @param target the object to validate
     * @return the same object if valid, null if not
     */
    default T validate(T target) {
        return target;
    }
}

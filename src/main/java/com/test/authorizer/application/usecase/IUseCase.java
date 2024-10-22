package com.test.authorizer.application.usecase;

import com.test.authorizer.presentation.output.ResponseDto;

public interface IUseCase<I,O> {

    O execute(I source);
}

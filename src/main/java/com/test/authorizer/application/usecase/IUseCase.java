package com.test.authorizer.application.usecase;

import com.test.authorizer.presentation.output.ResponseDto;

public interface IUseCase<I,O> {

    ResponseDto<O> execute(I source);
}

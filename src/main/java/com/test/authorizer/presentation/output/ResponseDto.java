package com.test.authorizer.presentation.output;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Response dto.
 *
 * @param <T> the type parameter
 */
@Builder
@AllArgsConstructor
@Getter
@Setter
public class ResponseDto<T> {
    private boolean success;
    private T data;
    private List<String> errors;

    public ResponseDto(T data) {
        success =  true;
        errors = new ArrayList<>();
        this.data = data;
    }

    public ResponseDto(T data, List<String> errors) {
        success =  false;
        this.errors = errors;
        this.data = data;
    }
}

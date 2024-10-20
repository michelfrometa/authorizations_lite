package com.test.authorizer.presentation.output;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Response dto.
 *
 * @param <T> the type parameter
 */
@Data
@Builder
@AllArgsConstructor
public class ResponseDto<T> {
    private boolean success;
    private T data;
    private List<String> errors;

    public ResponseDto() {
        this.errors = new ArrayList<>();
    }
}

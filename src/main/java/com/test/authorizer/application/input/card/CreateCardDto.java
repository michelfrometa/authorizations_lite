package com.test.authorizer.application.input.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateCardDto {

    @NotBlank
    @JsonProperty("numeroCartao")
    private BigInteger number;

    @NotBlank
    @JsonProperty("senha")
    private String password;

}

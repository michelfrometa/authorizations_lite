package com.test.authorizer.application.input;

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
public class CreateTransactionDto {

    @NotBlank
    @JsonProperty("numeroCartao")
    private BigInteger cardNumber;

    @NotBlank
    @JsonProperty("senhaCartao")
    private String cardPassword;

    @NotBlank
    @JsonProperty("valor")
    private double amount;
}

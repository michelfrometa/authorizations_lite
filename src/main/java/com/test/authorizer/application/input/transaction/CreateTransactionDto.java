package com.test.authorizer.application.input.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @JsonProperty("numeroCartao")
    private BigInteger cardNumber;

    @NotBlank
    @JsonProperty("senhaCartao")
    private String cardPassword;

    @JsonProperty("valor")
    private double amount;
}

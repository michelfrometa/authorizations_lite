package com.test.authorizer.application.input.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class GetTransactionDto {

    @JsonProperty("numeroCartao")
    private BigInteger cardNumber;

    @JsonProperty("senhaCartao")
    private String cardPassword;

    @JsonProperty("valor")
    private Double amount;
}

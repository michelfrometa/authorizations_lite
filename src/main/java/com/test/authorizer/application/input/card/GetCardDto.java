package com.test.authorizer.application.input.card;

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
public class GetCardDto {

    @JsonProperty("numeroCartao")
    private BigInteger number;

    @JsonProperty("senha")
    private String password;

    @JsonProperty("saldo")
    private Double balance;
}

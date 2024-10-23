package com.test.authorizer.infraestructure.persistence.mysql.repository.card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CardBalanceOnlyDto {

    @JsonProperty("saldo")
    private double balance;
}

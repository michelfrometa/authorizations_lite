package com.test.authorizer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Card extends BaseEntity {

    private BigInteger number;

    private String password;

    private double balance;

    private List<Transaction> transactions;

    private User user;

}

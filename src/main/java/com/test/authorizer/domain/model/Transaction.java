package com.test.authorizer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Transaction extends BaseEntity {
    // TODO Implement this in a record, or create a new BaseUnmodifiableEntity

    private double amount;

    private Card card;
}

package com.test.authorizer.infraestructure.persistence.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Card extends BaseEntity {
    private BigInteger number;
    private String password;
    private float balance;

    @OneToMany(mappedBy = "card")
    private List<Transaction> transactions;
}

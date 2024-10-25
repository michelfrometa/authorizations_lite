package com.test.authorizer.infraestructure.persistence.mysql.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Card extends BaseEntity {

    @Column(unique = true)
    private BigInteger number;

    private String password;

    private double balance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "card")
    private List<Transaction> transactions; // fixme Mudar las relaciones con List para Set

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Card addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        transaction.setCard(this);
        return this;
    }

    public Card deleteTransaction(Transaction transaction) {
        this.transactions.remove(transaction);
        transaction.setCard(null);
        return this;
    }

}

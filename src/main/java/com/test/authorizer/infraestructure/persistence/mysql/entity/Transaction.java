package com.test.authorizer.infraestructure.persistence.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction extends BaseEntity {

    private float amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "card_id")
    private Card card;
}

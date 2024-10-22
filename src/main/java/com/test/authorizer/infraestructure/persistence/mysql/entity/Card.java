package com.test.authorizer.infraestructure.persistence.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cards")
@Getter
@Setter
public class Card extends BaseEntity {
    private String number;
    private String password;
    private float balance;
}

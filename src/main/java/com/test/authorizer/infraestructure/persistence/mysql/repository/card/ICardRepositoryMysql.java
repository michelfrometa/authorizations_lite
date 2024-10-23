package com.test.authorizer.infraestructure.persistence.mysql.repository.card;

import com.test.authorizer.infraestructure.persistence.mysql.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardRepositoryMysql extends JpaRepository<Card, Long> {
}

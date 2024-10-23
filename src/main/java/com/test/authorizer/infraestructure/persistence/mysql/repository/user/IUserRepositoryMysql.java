package com.test.authorizer.infraestructure.persistence.mysql.repository.user;

import com.test.authorizer.infraestructure.persistence.mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepositoryMysql extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);
}

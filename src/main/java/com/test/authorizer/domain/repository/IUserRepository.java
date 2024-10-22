package com.test.authorizer.domain.repository;

import com.test.authorizer.domain.model.User;

import java.util.Optional;

public interface IUserRepository {

    User save(User user);

    Optional<User> findByUserName(String username);

}

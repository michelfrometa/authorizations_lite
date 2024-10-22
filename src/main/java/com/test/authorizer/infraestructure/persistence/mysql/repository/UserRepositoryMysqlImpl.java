package com.test.authorizer.infraestructure.persistence.mysql.repository;

import com.test.authorizer.domain.model.User;
import com.test.authorizer.domain.repository.IUserRepository;
import com.test.authorizer.infraestructure.persistence.mysql.mapper.IUserMySqlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryMysqlImpl implements IUserRepository {
    private final IUserRepositoryMysql userRepositoryMysql;
    private final IUserMySqlMapper mapper;

    @Override
    public User save(User user) {
        return Optional.of(user)
                .map(mapper::toPersistenceModel)
                .map(userRepositoryMysql::save)
                .map(mapper::toEntity)
                .orElse(null);
    }

    @Override
    public Optional<User> findByUserName(String username) {
        return userRepositoryMysql.findByUsername(username)
                .map(mapper::toEntity);
    }
}

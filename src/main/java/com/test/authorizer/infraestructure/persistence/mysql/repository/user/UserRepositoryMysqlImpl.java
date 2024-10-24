package com.test.authorizer.infraestructure.persistence.mysql.repository.user;

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

    /**
     * Saves a user to the database.
     *
     * @param user the user to save
     * @return the saved user if successful, otherwise null
     */
    @Override
    public User save(User user) {
        return Optional.of(user)
                .map(mapper::toPersistenceModel)
                .map(userRepositoryMysql::save)
                .map(mapper::toEntity)
                .orElse(null);
    }

    /**
     * Finds a user by their username.
     *
     * @param username the username to search for
     * @return an optional containing the user if found, otherwise an empty optional
     */
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepositoryMysql.findByUsername(username)
                .map(mapper::toEntity);
    }
}

package com.test.authorizer.infraestructure.persistence.mysql.repository;

import com.test.authorizer.domain.model.User;
import com.test.authorizer.infraestructure.persistence.mysql.mapper.IUserMySqlMapper;
import com.test.authorizer.infraestructure.persistence.mysql.repository.user.IUserRepositoryMysql;
import com.test.authorizer.infraestructure.persistence.mysql.repository.user.UserRepositoryMysqlImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryMysqlImplTest {

    @Mock
    private IUserRepositoryMysql userRepositoryMysql;

    @Mock
    private IUserMySqlMapper mapper;

    @InjectMocks
    private UserRepositoryMysqlImpl userRepositoryMysqlImpl;

    private User user;
    private com.test.authorizer.infraestructure.persistence.mysql.entity.User savedUser;

    @BeforeEach
    void setUp() {
        user = new User();
        savedUser = new com.test.authorizer.infraestructure.persistence.mysql.entity.User();

    }

    @Test
    public void testSave() {
        // Arrange
        when(mapper.toPersistenceModel(eq(user))).thenReturn(savedUser);
        when(userRepositoryMysql.save(eq(savedUser))).thenReturn(savedUser);
        when(mapper.toEntity(eq(savedUser))).thenReturn(user);

        // Act
        User savedUser = userRepositoryMysqlImpl.save(user);

        // Assert
        assertNotNull(savedUser);
        verify(userRepositoryMysql).save(any());
    }

    @Test
    public void testSave_WithNullUser() {
        // Arrange
        User user = null;

        // Act and Assert
        try {
            userRepositoryMysqlImpl.save(user);
            assert false;
        } catch (NullPointerException e) {
            assert true;
        }
    }

    @Test
    public void testSave_WithMapperReturningNull() {
        // Arrange
        User user = new User();
        when(mapper.toPersistenceModel(user)).thenReturn(null);

        // Act and Assert
        assertEquals(userRepositoryMysqlImpl.save(user), null);
    }

    @Test
    public void testFindByUsername_NotFound() {
        // Arrange
        when(userRepositoryMysql.findByUsername(any())).thenReturn(Optional.empty());

        // Act
        Optional<User> result = userRepositoryMysqlImpl.findByUsername("non-existent-username");

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindByUsername_Found() {
        // Arrange
        when(userRepositoryMysql.findByUsername(any())).thenReturn(Optional.of(savedUser));
        when(mapper.toEntity(eq(savedUser))).thenReturn(user);

        // Act
        Optional<User> result = userRepositoryMysqlImpl.findByUsername("existing-username");

        // Assert
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    public void testFindByUsername_NullInput() {
        // Act
        Optional<User> result = userRepositoryMysqlImpl.findByUsername(null);

        // Assert
        assertTrue(result.isEmpty());
    }
}


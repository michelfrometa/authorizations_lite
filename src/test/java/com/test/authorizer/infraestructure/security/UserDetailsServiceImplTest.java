package com.test.authorizer.infraestructure.security;
import com.test.authorizer.domain.model.User;
import com.test.authorizer.domain.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Test
    void testUserFound() {
        // Arrange
        String username = "testuser";
        User user = User.builder().username(username).password("password").build();
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        // Act
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);

        // Assert
        assertEquals(username, userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
    }

    @Test
    void testUserNotFound() {
        // Arrange
        String username = "invaliduser";
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        // Act and Assert
        UsernameNotFoundException exception = assertThrows(UsernameNotFoundException.class, () -> userDetailsServiceImpl.loadUserByUsername(username));
        assertEquals("User not found with email id: " + username, exception.getMessage());
    }

    @Test
    void testNullUsername() {
        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> userDetailsServiceImpl.loadUserByUsername(null));
    }

    @Test
    void testEmptyUsername() {
        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> userDetailsServiceImpl.loadUserByUsername(""));
    }
}
package com.test.authorizer.domain.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.UniqueConstraint;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity implements UserDetails {

    // todo Unique
    private String username;
    private String password;

    private Collection<? extends GrantedAuthority> authorities; // TODO

}

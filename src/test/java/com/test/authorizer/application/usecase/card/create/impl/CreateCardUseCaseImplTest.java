package com.test.authorizer.application.usecase.card.create.impl;
/*

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.usecase.card.create.ICreateCardValidator;
import com.test.authorizer.application.usecase.card.mapper.ICardMapper;
import com.test.authorizer.domain.model.Card;
import com.test.authorizer.domain.repository.ICardRepository;
import com.test.authorizer.domain.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;

import java.math.BigInteger;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCardUseCaseTest {

    @Mock
    private ICardRepository repository;
    @Mock
    private IUserRepository iUserRepository;

    @Mock
    private ICardMapper mapper;

    private final String PASSWORD = "PASSWORD";

    @InjectMocks
    private CreateCardUseCaseImpl CreateCardUseCaseImpl;
    private final BigInteger CARD_NUMBER = new BigInteger("6549873025634501");
    @Mock
    private ICreateCardValidator validator;

    @Test
    void execute_ValidInput_ReturnsCardDto() {   // Arrange
        UserDetails userDetails = new User("testUser", PASSWORD, Collections.emptyList());
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        CreateCardDto inputDto = CreateCardDto.builder().number(CARD_NUMBER).password(PASSWORD).build();

        Card card = Card.builder().id(1L).number(CARD_NUMBER).password(PASSWORD).balance(500f).build();
        CardDto expectedOutput = new CardDto(1L, CARD_NUMBER, PASSWORD, 500f);

        when(mapper.toEntity(inputDto)).thenReturn(card);
        when(repository.save(card)).thenReturn(card);
        when(repository.existsByNumberAndPassword(eq(CARD_NUMBER), eq(PASSWORD))).thenReturn(true);
        when(validator.validate(any(CreateCardDto.class), anyBoolean())).thenReturn(inputDto);
        when(mapper.toDto(card)).thenReturn(expectedOutput);

        // Act
        CardDto output = CreateCardUseCaseImpl.execute(inputDto);

        // Assert
        assertEquals(expectedOutput, output);
        //verify(validator).validate(inputDto); Fixme Nullpointer Exception
        verify(mapper).toEntity(inputDto);
        verify(repository).save(card);
        verify(mapper).toDto(card);
    }

    @Test
    void execute_InvalidInput_ReturnsNull() {
        // Arrange
        CreateCardDto inputDto = CreateCardDto.builder().number(CARD_NUMBER).password(PASSWORD).build();

        when(repository.existsByNumberAndPassword(eq(CARD_NUMBER), eq(PASSWORD))).thenReturn(false);
        when(validator.validate(any(CreateCardDto.class), anyBoolean())).thenReturn(null);

        // Act
        CardDto output = CreateCardUseCaseImpl.execute(inputDto);

        // Assert
        assertNull(output);
        verify(validator).validate(inputDto, false);
    }
}*/

import com.test.authorizer.application.input.card.CardDto;
import com.test.authorizer.application.input.card.CreateCardDto;
import com.test.authorizer.application.usecase.card.create.ICreateCardValidator;
import com.test.authorizer.application.usecase.card.mapper.ICardMapper;
import com.test.authorizer.domain.model.Card;
import com.test.authorizer.domain.model.User;
import com.test.authorizer.domain.repository.ICardRepository;
import com.test.authorizer.domain.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCardUseCaseImplTest {

    private final BigInteger CARD_NUMBER = new BigInteger("6549873025634501");
    private final String PASSWORD = "PASSWORD";
    @Mock
    private ICardRepository iCardRepository;
    @Mock
    private IUserRepository iUserRepository;
    @Mock
    private ICardMapper iCardMapper;
    @Mock
    private ICreateCardValidator iCreateCardValidator;
    @InjectMocks
    private CreateCardUseCaseImpl createCardUseCaseImpl;

    @Test
    void execute_ValidInput_ReturnsCardDto() {
        // Arrange
        UserDetails userDetails = new User("testUser", PASSWORD, Collections.emptyList());
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        CreateCardDto inputDto = CreateCardDto.builder().number(CARD_NUMBER).password(PASSWORD).build();
        Card card = Card.builder().number(CARD_NUMBER).password(PASSWORD).build();
        CardDto expectedOutput = CardDto.builder().number(CARD_NUMBER).balance(500).build();

        when(iCreateCardValidator.validate(any(CreateCardDto.class), anyBoolean())).thenReturn(inputDto);
        when(iCardMapper.toEntity(any(CreateCardDto.class))).thenReturn(card);
        when(iCardRepository.save(any(Card.class))).thenReturn(card);
        when(iCardMapper.toDto(any(Card.class))).thenReturn(expectedOutput);
        when(iCardRepository.existsByNumberAndPassword(eq(CARD_NUMBER), eq(PASSWORD))).thenReturn(true);

        // Act
        CardDto output = createCardUseCaseImpl.execute(inputDto);

        // Assert
        assertEquals(expectedOutput, output);
        verify(iCreateCardValidator).validate(inputDto, true);
        verify(iCardMapper).toEntity(inputDto);
        verify(iCardRepository).save(card);
        verify(iCardMapper).toDto(card);
    }

    @Test
    void execute_InvalidInput_ReturnsNull() {
        // Arrange
        CreateCardDto inputDto = CreateCardDto.builder().number(CARD_NUMBER).password(PASSWORD).build();

        when(iCreateCardValidator.validate(any(CreateCardDto.class), anyBoolean())).thenReturn(null);

        // Act
        CardDto output = createCardUseCaseImpl.execute(inputDto);

        // Assert
        assertNull(output);
        verify(iCardMapper, never()).toEntity(any(CreateCardDto.class));

    }
}
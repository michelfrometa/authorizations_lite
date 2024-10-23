package com.test.authorizer.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.authorizer.application.input.CreateUserDto;
import com.test.authorizer.application.input.UserDto;
import com.test.authorizer.application.usecase.user.IUserUserCases;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    /* TODO Activate this tests

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserUserCases userService;

    @Test
    @WithMockUser(username = "testuser", roles = "USER")
    public void testSaveAnalysisDocument() throws Exception {
        // Arrange
        CreateUserDto createUserDto = CreateUserDto.builder().username("testuser").password("password").build();
        UserDto expectedUserDto = UserDto.builder().username("testuser").password("password").build();

        when(userService.create(any(CreateUserDto.class))).thenReturn(expectedUserDto);

        // Act and Assert
        mockMvc.perform(post("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(createUserDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("testuser"))
                .andExpect(jsonPath("$.password").value("password"));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
}
package com.test.authorizer.presentation.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

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
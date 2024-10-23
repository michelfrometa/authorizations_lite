package com.test.authorizer.presentation.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(CardController.class)
@AutoConfigureMockMvc
public class CardControllerTest {/*
    /* TODO Activate this tests

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICardUseCaseService userService;

    @Test
    @WithMockUser(username = "testuser", roles = "USER")
    public void testSaveAnalysisDocument() throws Exception {
        // Arrange
        CreateCardDto createCardDto = CreateCardDto.builder().number("password").password("password").build();
        CardDto expectedCardDto = CardDto.builder().number("password").password("password").build();

        when(userService.create(any(CreateCardDto.class))).thenReturn(expectedCardDto);

        // Act and Assert
        mockMvc.perform(post("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(createCardDto)))
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
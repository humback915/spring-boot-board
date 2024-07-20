package org.springboot.board.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springboot.board.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@DisplayName("View Controller Auth Test")
@WebMvcTest
@Import(SecurityConfig.class)
public class AuthControllerTests {

    private final MockMvc mockMvc;

    public AuthControllerTests(@Autowired MockMvc mockMvc){
        this.mockMvc = mockMvc;
    }

    @DisplayName("1. Get Login Page")
    @Test
    public void given_whenTryLogin_thenReturnLoginView() throws Exception {
        // given

        // when
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                ;
        // then
    }

}

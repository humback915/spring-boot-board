package org.springboot.board.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springboot.board.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DisplayName("View ArticleController Test")
@Import(SecurityConfig.class)
@WebMvcTest
class ArticleControllerTest {

    private final MockMvc mockMvc;

    public ArticleControllerTest(@Autowired MockMvc mockMvc){
        this.mockMvc = mockMvc;
    }


    @DisplayName("1. Get Article List")
    @Test
    public void given_whenRequestArticlesListView_thenArticlesListView() throws Exception {
        // given

        // when
        mockMvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/index"))
                .andExpect(model().attributeExists("articles"));
        // then
    }

    @DisplayName("2. Get Article detail")
    @Test
    public void given_whenRequestArticleDetailView_thenArticleDetailView() throws Exception {
        // given

        // when
        mockMvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments"));
        // then
    }
    @Disabled
    @DisplayName("3. Search Articles")
    @Test
    public void given_whenRequestArticleSearch_thenArticleSearchView() throws Exception {
        // given

        // when
        mockMvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search"));

        // then
    }
    @Disabled
    @DisplayName("4. Search hashtag Articles ")
    @Test
    public void given_whenRequestArticleSearchhashtag_thenArticleSearchhashtagView() throws Exception {
        // given

        // when
        mockMvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search-hashtag"));
        // then
    }
}
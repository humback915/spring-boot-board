package org.springboot.board.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Data Rest 테스트")
@Transactional // Spring 트랜잭션 import 확인, 인테그레이션테스트임으로 직접 DB에 영향을 주기때문에 트랜잭션널을 사용하여 롤백시킨다.
@AutoConfigureMockMvc
@SpringBootTest
class RestTest {

    private final MockMvc mockMvc;

    RestTest(@Autowired MockMvc mockMvc){
        this.mockMvc = mockMvc;
    }

    @DisplayName("게시글 리스트 조회")
    @Test
    void article_list() throws Exception {
        // test
        mockMvc.perform(get("/api/articles")) // # import static
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("게시글 조회")
    @Test
    void article_select() throws Exception {
        // test
        mockMvc.perform(get("/api/articles/1")) // # import static
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("게시글 댓글 리스트 조회")
    @Test
    void article_comments_list() throws Exception {
        // test
        mockMvc.perform(get("/api/articles/1/articleComments")) // # import static
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("댓글 리스트 조회")
    @Test
    void comments_list() throws Exception {
        // test
        mockMvc.perform(get("/api/articleComments")) // # import static
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("댓글 조회")
    @Test
    void comment_select() throws Exception {
        // test
        mockMvc.perform(get("/api/articleComments/1")) // # import static
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }
}

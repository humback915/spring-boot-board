package org.springboot.board.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void test(){
        User user = new User();
        user.setEmail("hong@naver.com");
        user.setName("hong");
        User user1 = User.builder()
                .email("gil@naver.com")
                .name("gil")
                .build();
        System.out.println("result : "+user);
    }

}

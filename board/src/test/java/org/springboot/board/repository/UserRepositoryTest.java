package org.springboot.board.repository;

import org.junit.jupiter.api.Test;
import org.springboot.board.config.JpaConfig;
import org.springboot.board.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@Import(JpaConfig.class) /** JpaConfig안에서 만든 Auditing이 적용이 안되고 테스트에서 JpaConfig를 인식시키기 위함 */
@DataJpaTest
class UserRepositoryTest {

    private UserRepository userRepository;

    public UserRepositoryTest(@Autowired UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Test
    void crud(){
        userRepository.save(new User());
        userRepository.findAll().forEach(System.out::println);
    }
}

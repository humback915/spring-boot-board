package org.springboot.board.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@Configuration
public class ThymeleafConfig {

    @Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver(
            SpringResourceTemplateResolver defaultTemplateResolver,
            Thymeleaf3Properties thymeleaf3Properties
    ) {
        /** decoupledLogic을 view resolver에 설정 */
        defaultTemplateResolver.setUseDecoupledLogic(thymeleaf3Properties.isDecoupledLogic());

        return defaultTemplateResolver;
    }


    @RequiredArgsConstructor
    @Getter
    @ConstructorBinding
    @ConfigurationProperties("spring.thymeleaf3") // 유저가 직접 Config 생성시 직접 스캔처리해야함 메인 애플리케이션에 @ConfigurationPropertiesScan추가
    public static class Thymeleaf3Properties {
        /**
         * Use Thymeleaf 3 Decoupled Logic
         */
        private final boolean decoupledLogic;

        /* @RequiredArgsConstructor 사용으로 주석
        public Thymeleaf3Properties(boolean decoupledLogic) {
            this.decoupledLogic = decoupledLogic;
        }
        @Getter 사용으로 주석
        public boolean isDecoupledLogic() {
            return this.decoupledLogic;
        }
        */
    }

}
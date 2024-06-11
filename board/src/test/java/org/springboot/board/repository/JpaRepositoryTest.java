package org.springboot.board.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springboot.board.config.JpaConfig;
import org.springboot.board.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

//import static org.junit.jupiter.api.Assertions.*; /** junit5 test 도구 */
import java.util.List;

import static org.assertj.core.api.Assertions.*; /** assertj test */

@DisplayName("JPA 연결 테스")
@Import(JpaConfig.class) /** JpaConfig안에서 만든 Auditing이 적용이 안되고 테스트에서 JpaConfig를 인식시키기 위함 */
@DataJpaTest
class JpaRepositoryTest {

    /** @Autowired는 @DataJpaTest 에서 적용 되도록 지정 */
    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(@Autowired ArticleRepository articleRepository, @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select test")
    @Test
    void selectAll_test(){
        // setting

        // exec
        List<Article> articleList = articleRepository.findAll();

        // confirm
        assertThat(articleList)
                .isNotNull()
                .hasSize(3 );
    }

    @DisplayName("insert test")
    @Test
    void insert_test(){
        // setting
        long prev_count = articleRepository.count();

        // exec
        Article article = articleRepository.save(Article.of("spring","spring boot test content", "#spring"));

        // confirm
        assertThat(articleRepository.count())
                .isEqualTo(prev_count+1);
    }

    @DisplayName("update test")
    @Test
    void update_test(){
        // setting
        Article article = articleRepository.findById(1L).orElseThrow();
        article.setHashtag("#springboot");

        // exec
        Article savedArticle = articleRepository.saveAndFlush(article);

        // confirm
        assertThat(savedArticle)
                .hasFieldOrPropertyWithValue("hashtag","#springboot");
    }

    @DisplayName("delete test")
    @Test
    void delete_test(){
        // setting
        Article article = articleRepository.findById(2L).orElseThrow();
        long prev_count = articleRepository.count();
        long prev_comment_count = articleCommentRepository.count();
        long deleted_comment_size = article.getArticleComments().size();

        // exec
        articleRepository.delete(article);

        // confirm
        assertThat(articleRepository.count()).isEqualTo(prev_count -1);
        assertThat(articleCommentRepository.count()).isEqualTo(prev_comment_count - deleted_comment_size);
    }
}
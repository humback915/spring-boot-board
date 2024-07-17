package org.springboot.board.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springboot.board.domain.Article;
import org.springboot.board.domain.QArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource // strategy option from yaml
public interface ArticleRepository extends
        JpaRepository<Article, Long>,QuerydslPredicateExecutor<Article>, QuerydslBinderCustomizer<QArticle> {


    /**
     * QuerydslPredicateExecutor<T>
     * 쿼리 검색에 대한 기본적인 Repository 제공
     * 하지만, exact match에 대한 기능만 제공
     * findOne, fineAll, findBy...
     **/
    /**
     * QuerydslBinderCustomizer<T>
     * 쿼리 검색에 대한 커스텀
     * like와 같은 포함 검색 기능을 커스텀할 수 있다.
     * @param bindings
     * @param root
     */
    @Override
    default void customize(QuerydslBindings bindings, QArticle root){
        bindings.excludeUnlistedProperties(true); // 리스트 되지 않은 프로퍼티는 제외
        bindings.including(root.title, root.content, root.hashtag, root.createdAt, root.createdBy); // 검색 대상 필드 포함 지정
        //bindings.bind(root.title).first(StringExpression::likeIgnoreCase); // like '${val}'
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase); // like '%${val}%'
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);

    }
}

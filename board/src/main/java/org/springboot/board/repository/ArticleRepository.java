package org.springboot.board.repository;

import org.springboot.board.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource // strategy option from yaml
public interface ArticleRepository extends JpaRepository<Article, Long> {
}

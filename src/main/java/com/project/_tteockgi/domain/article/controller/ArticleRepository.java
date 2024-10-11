package com.project._tteockgi.domain.article.controller;

import com.project._tteockgi.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}

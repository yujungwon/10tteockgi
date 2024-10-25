package com.project._tteockgi.domain.article.repository;

import com.project._tteockgi.domain.article.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository  extends JpaRepository<ArticleComment, Long> {
}

package com.project._tteockgi.domain.article.service;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.article.repository.ArticleRepository;
import com.project._tteockgi.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }


    public void create (String title, String content, Member member) {
        Article article = new Article();

        article.setTitle(title);
        article.setContent(content);
        article.setMember(member);
        article.setCreatedAt(LocalDateTime.now());

        this.articleRepository.save(article);
    }
}

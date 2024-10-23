package com.project._tteockgi.domain.article.service;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.article.repository.ArticleRepository;
import com.project._tteockgi.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public void create(String title, String content, Member member) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setMember(member);
        this.articleRepository.save(article);
    }

    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }
    public void create(String title, String content, int price) {
        Article q = new Article();
       q. setTitle(q.getTitle());
        q.setContent(content);
       q.setPrice(q.getPrice());
        this.articleRepository.save(q);
    }
}



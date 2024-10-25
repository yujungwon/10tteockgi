package com.project._tteockgi.domain.article.service;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.article.entity.ArticleComment;
import com.project._tteockgi.domain.article.repository.ArticleCommentRepository;
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
    private final ArticleCommentRepository articleCommentRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public void create(String title, String content, int price,Member member) {
        Article article = new Article();
        article. setTitle(title);
        article.setContent(content);
        article.setPrice(price);
        article.setMember(member);
        this.articleRepository.save(article);
    }

    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }

    public void modify(Article article, String title, String content, int price) {
            article.setTitle(title);
            article.setContent(content);
            article.setPrice(price);
        this.articleRepository.save(article);
    }

    public void delete(Long id) {
        this.articleRepository.deleteById(id);
    }

    public void createComment(Article article, Member member, String content) {
        ArticleComment ac = new ArticleComment();
        ac.setArticle(article);
        ac.setMember(member);
        ac.setContent(content);

        this.articleCommentRepository.save(ac);
    }
}



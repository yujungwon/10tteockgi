package com.project._tteockgi.domain.wishlist.entity;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.member.entity.Member;
import jakarta.persistence.*;

@Entity
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;


    public Wishlist() {}

    public Wishlist(Member member, Article article) {
        this.member = member;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Article getArticle() {
        return article;
    }
}

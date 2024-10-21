package com.project._tteockgi.domain.wishlist.entity;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.member.entity.Member;
import jakarta.persistence.*;

@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
}

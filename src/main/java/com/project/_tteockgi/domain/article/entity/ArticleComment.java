package com.project._tteockgi.domain.article.entity;

import com.project._tteockgi.domain.member.entity.Member;
import com.project._tteockgi.global.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleComment extends BaseEntity {
    @ManyToOne
    private Article article;

    @ManyToOne
    private Member member;

    @Column(columnDefinition = "TEXT")
    private String content;
}

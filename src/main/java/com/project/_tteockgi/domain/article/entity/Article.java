package com.project._tteockgi.domain.article.entity;

import com.project._tteockgi.domain.member.entity.Member;
import com.project._tteockgi.global.global.jpa.BaseEntity;
import jakarta.persistence.*;
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
public class Article extends BaseEntity {
    @ManyToOne
    private Member member;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private String title;
}

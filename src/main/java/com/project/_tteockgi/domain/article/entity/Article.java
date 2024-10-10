package com.project._tteockgi.domain.article.entity;

import com.project._tteockgi.domain.member.entity.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity

public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = true)
    private Integer postId;

    @ManyToOne
    private Member member;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private String title;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

}

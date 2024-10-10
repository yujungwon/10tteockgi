package com.project._tteockgi.domain.auction.entity;

import com.project._tteockgi.domain.member.entity.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

    public class Auction {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        private int id;


        @ManyToOne
        private Member member;

        @Column(length = 255) // You can set the char length based on your needs
        private String content;

        @Column(length = 255)
        private String title;

        @Column(length = 255)
        private String comment;

        @Column
        private LocalDateTime startTime;

        @Column(nullable = false)
        private LocalDateTime createdAt;

        @Column
        private LocalDateTime updatedAt;
}

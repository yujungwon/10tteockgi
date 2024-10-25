package com.project._tteockgi.domain.auction.entity;

import com.project._tteockgi.domain.member.entity.Member;
import com.project._tteockgi.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Auction extends BaseEntity {
        @ManyToOne
        private Member member;

        @Column
        private String content;

        @Column(length = 255)
        private String title;

        @Column
        private int startPrice;
//
//        @Column
//        private LocalDateTime startDate;
//
//        @Column
//        private LocalDateTime endDate;

        @OneToMany(mappedBy = "auction", cascade = CascadeType.REMOVE)
        private List<AuctionComment> commentList;
}



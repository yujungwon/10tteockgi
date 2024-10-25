package com.project._tteockgi.domain.auction.entity;

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
public class AuctionComment extends BaseEntity {
    @ManyToOne
    private Auction auction;

    @ManyToOne
    private Member member;

    @Column(columnDefinition = "TEXT")
    private String content;
}

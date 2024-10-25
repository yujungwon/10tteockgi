package com.project._tteockgi.domain.auction.repository;

import com.project._tteockgi.domain.auction.entity.AuctionComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionCommentRepository extends JpaRepository<AuctionComment, Long> {
}

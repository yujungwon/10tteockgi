package com.project._tteockgi.domain.auction.service;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.auction.entity.Auction;
import com.project._tteockgi.domain.auction.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuctionService {
    private AuctionRepository auctionRepository;

    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }


}

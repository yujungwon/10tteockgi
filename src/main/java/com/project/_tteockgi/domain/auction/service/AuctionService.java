package com.project._tteockgi.domain.auction.service;

import com.project._tteockgi.domain.auction.entity.Auction;
import com.project._tteockgi.domain.auction.repository.AuctionRepository;
import com.project._tteockgi.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuctionService {
    private final AuctionRepository auctionRepository;

    public List<Auction> getList() {
        return auctionRepository.findAll();
    }

    public void create (String title, String content, Member member) {
        Auction auction = new Auction();

        auction.setTitle(title);
        auction.setContent(content);
        auction.setMember(member);

        this.auctionRepository.save(auction);
    }

}

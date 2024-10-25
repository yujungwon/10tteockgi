package com.project._tteockgi.domain.auction.service;

import com.project._tteockgi.domain.auction.entity.Auction;
import com.project._tteockgi.domain.auction.entity.AuctionComment;
import com.project._tteockgi.domain.auction.repository.AuctionCommentRepository;
import com.project._tteockgi.domain.auction.repository.AuctionRepository;
import com.project._tteockgi.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuctionService {
    private final AuctionRepository auctionRepository;
    private final AuctionCommentRepository auctionCommentRepository;

    public List<Auction> getList() {
        return auctionRepository.findAll();
    }

    public void create(String title, String content, Member member) {
        Auction auction = new Auction();

        auction.setTitle(title);
        auction.setContent(content);
        auction.setMember(member);

        this.auctionRepository.save(auction);
    }

    public Optional<Auction> findById(Long id) {
        return auctionRepository.findById(id);
    }

    public void create(String title, String content, Member member, int startPrice) {
        Auction auction = new Auction();

        auction.setMember(member);
        auction.setTitle(title);
        auction.setContent(content);
        auction.setStartPrice(startPrice);
//        auction.setStartDate(startDate);
//        auction.setEndDate(endDate);


        auctionRepository.save(auction);
    }

    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }


    public void delete(Long id) {
        this.auctionRepository.findById(id);
    }

    public void Modifiy(Auction auction, String title, String content, Member member, int startPrice) {
        auction.setMember(member);
        auction.setTitle(title);
        auction.setContent(content);
        auction.setStartPrice(startPrice);
    }

    public void createComment(Auction auction, Member member, String content) {
        AuctionComment ac = new AuctionComment();
        ac.setAuction(auction);
        ac.setMember(member);
        ac.setContent(content);

        this.auctionCommentRepository.save(ac);

    }
}

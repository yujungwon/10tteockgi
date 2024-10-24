package com.project._tteockgi.domain.auction.service;

import com.project._tteockgi.domain.auction.entity.Auction;
import com.project._tteockgi.domain.auction.repository.AuctionRepository;
import com.project._tteockgi.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuctionService {
    private final AuctionRepository auctionRepository;

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

    public void create(String title, String content, Member member, int startPrice, LocalDate startDate, LocalDate  endDate) {
        Auction auction = new Auction();

        auction.setMember(member);
        auction.setTitle(title);
        auction.setContent(content);
        auction.setStartPrice(startPrice);
        auction.setStartDate(startDate.atStartOfDay());
        auction.setEndDate(endDate.atStartOfDay());


        auctionRepository.save(auction);
    }

    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }


}

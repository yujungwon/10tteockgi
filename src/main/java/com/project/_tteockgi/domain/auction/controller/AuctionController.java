package com.project._tteockgi.domain.auction.controller;

import com.project._tteockgi.domain.auction.entity.Auction;
import com.project._tteockgi.domain.auction.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AuctionController {
    private final AuctionService auctionService;

    @GetMapping("/auction/list")
    public String list(Model model) {
        List<Auction> auctionList = this.auctionService.getList();
        model.addAttribute("auctionList", auctionList);

        return "auction_list";
    }
}

package com.project._tteockgi.domain.auction.controller;

import com.project._tteockgi.domain.auction.entity.Auction;
import com.project._tteockgi.domain.auction.service.AuctionService;
import com.project._tteockgi.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AuctionController {
    private final AuctionService auctionService;
    private  final MemberService memberService;

    @GetMapping("/auction/list")
    public String list(Model model) {
        List<Auction> auctionList = this.auctionService.getList();
        model.addAttribute("auctionList", auctionList);

        return "auction_list";
    }

    @GetMapping("/auction/detail/{id}")
    public String detail(Model model, @PathVariable("id") long id) {
            Auction auction = auctionService.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid auction ID:" + id));
            model.addAttribute("auction", auction);
        return "auction_detail";
    }
    @GetMapping("/auction/form")
    public String form(){
       return "auction_form";
    }

    @PostMapping("/auction/create")
    public String create() {
        return "";
    }

}

package com.project._tteockgi.domain.auction.controller;

import com.project._tteockgi.domain.auction.entity.Auction;
import com.project._tteockgi.domain.auction.service.AuctionService;
import com.project._tteockgi.domain.member.entity.Member;
import com.project._tteockgi.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class AuctionController {
    private final AuctionService auctionService;
    private final MemberService memberService;

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
    public String auctionForm(Model model) {
        model.addAttribute("auction", new Auction());  // 새로운 Auction 객체 생성
        return "auction_form";  // auction_form.html 반환
    }


    @PostMapping("/auction/create")
    public String createAuction(@RequestParam("title") String title,
                                @RequestParam("content") String content,
                                @RequestParam("startPrice") int startPrice,
                                @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime startDate,
                                @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDateTime endDate,
                                Principal principal) {

        Member member = this.memberService.getMember(principal.getName());

        auctionService.create(title, content, member, startPrice);
        return "redirect:/auction/list";
    }

    @GetMapping("/auction/modify/{id}")
    public String auctionModifyForm(@PathVariable("id") Long id, Model model) {
       Auction auction = this.auctionService.findById(id).orElse(null);

       model.addAttribute("auction", auction);

        return "auction_modify_form";
    }

    @PostMapping("/auction/modify/{id}")
    public String auctionModify(
                                @PathVariable("id") Long id,
                                @RequestParam("title") String title,
                                @RequestParam("content") String content,
                                @RequestParam("startPrice") int startPrice,
                                Principal principal) {

        Member member = this.memberService.getMember(principal.getName());
        Auction auction = this.auctionService.findById(id).orElse(null);

        auctionService.Modifiy(auction, title, content, member, startPrice);
        return String.format("redirect:/auction/detail/%s", id);
    }

    @GetMapping("/auction/delete/{id}")
    public String auctionDelete(@PathVariable("id") Long id, Model model) {
        this.auctionService.delete(id);

        return "redirect:/auction/list";
    }

    @PostMapping("/auction/comment/{id}")
    public String createComment(@PathVariable("id") Long id, @RequestParam("content") String content, Principal principal) {
        Auction auction = this.auctionService.findById(id).orElse(null);

        Member member= this.memberService.getMember(principal.getName());

        this.auctionService.createComment(auction, member, content);

        return String.format("redirect:/auction/detail/%d", id);
    }
}

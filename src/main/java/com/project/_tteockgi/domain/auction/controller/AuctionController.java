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
import java.time.LocalDate;
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

 /* @PostMapping("/auction/create")
    public String create() {
      return "";

  }*/
    @GetMapping("/auction/form")
    public String auctionForm(Model model) {
        model.addAttribute("auction", new Auction());  // 새로운 Auction 객체 생성
        return "auction_form";  // auction_form.html 반환
    }


    @PostMapping("/auction/create")
    public String createAuction(@RequestParam("title") String title,
                                @RequestParam("content") String content,
                                @RequestParam("startPrice") int startPrice,
                                @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate endDate,
                                Principal principal) {

        Member member = this.memberService.getMember(principal.getName());

        auctionService.create(title, content, member, startPrice, startDate, endDate);
        return "redirect:/auction/list";
    }
}

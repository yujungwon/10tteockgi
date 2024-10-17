package com.project._tteockgi.domain.main.controller;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.article.service.ArticleService;
import com.project._tteockgi.domain.auction.entity.Auction;
import com.project._tteockgi.domain.auction.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController{
    private final ArticleService articleService;
    private final AuctionService auctionService;

    @GetMapping("/")
    public String index (Model model) {
        List<Article> articleList = articleService.getList();
        List<Auction> auctionList = auctionService.getList();

        model.addAttribute("articleList", articleList);
        model.addAttribute("auctionList", auctionList);

        return "main";
    }


}



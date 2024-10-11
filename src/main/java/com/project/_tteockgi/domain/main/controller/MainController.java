package com.project._tteockgi.domain.main.controller;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController{
    private final ArticleService articleService;


    @GetMapping("/")
    public String index (Model model) {
        List<Article> articleList = articleService.getList();

        model.addAttribute("articleList", articleList);

        return "main";
    }

}



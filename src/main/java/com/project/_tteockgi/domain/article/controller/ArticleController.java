package com.project._tteockgi.domain.article.controller;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {
@Autowired
    private final ArticleService articleService;

    @GetMapping("/article")
    public String index() {
        return "article";
    }

    @GetMapping("/article/list")
    public String list(Model model) {
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);

        return "article_list";
    }

    @GetMapping("/article/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        return "article_detail";


    }

    @GetMapping("/article/form")
    public String form(Model model) {
        model.addAttribute("article", new Article());
        return "article_form";
    }

    @PostMapping("/article/save")
    public String saveArticle(@ModelAttribute Article article) {
        articleService.saveArticle(article);
        return "redirect:/articles";
    }
}



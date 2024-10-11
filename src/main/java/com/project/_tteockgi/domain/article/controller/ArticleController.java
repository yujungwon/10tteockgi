package com.project._tteockgi.domain.article.controller;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleRepository articleRepository;

    @GetMapping("/article")
    public String index() {
        return "article";
    }

    @GetMapping("/article/list")
//      @ResponseBody
    public String list(Model model) {
        List<Article> articleList = this.articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        {
            return "article_list";
        }

    }
}



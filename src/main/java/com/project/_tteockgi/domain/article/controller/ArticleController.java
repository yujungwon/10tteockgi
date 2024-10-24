package com.project._tteockgi.domain.article.controller;

import com.project._tteockgi.domain.article.entity.Article;
import com.project._tteockgi.domain.article.service.ArticleService;
import com.project._tteockgi.domain.member.entity.Member;
import com.project._tteockgi.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;
    private final MemberService memberService;

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
    public String detail(Model model, @PathVariable("id") long id) {

        Article article = articleService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid article Id:" + id));
        model.addAttribute("article", article);
        return "article_detail";
    }


    @GetMapping("/article/form")
    public String form(Model model) {
        model.addAttribute("article", new Article());
        return "article_form";
    }


    @PostMapping("/article/create")
    public String createArticle(@RequestParam("title") String title,
                                @RequestParam("content") String content,
                                @RequestParam("price") int price, Principal principal) {

        Member member = this.memberService.getMember(principal.getName());


        articleService.create(title, content, price, member);

        return "redirect:/article/list";
    }

    @GetMapping("/article/modify/{id}")
    public String modifyArticle(@PathVariable("id") Long id, Model model) {
        Article article = this.articleService.findById(id).orElse(null);
        model.addAttribute("article", article);

        return "article_modify_form";
    }

    @PostMapping("/article/modify/{id}")
    public String modifyArticle(@PathVariable("id") Long id, @RequestParam("title") String title,
                                @RequestParam("content") String content,
                                @RequestParam("price") int price, Principal principal) {


        Article article = this.articleService.findById(id).orElse(null);

        if (article == null) {
            return "redirect:/";
        }

        this.articleService.modify(article, title, content, price);

        return String.format("redirect:/article/detail/%d", id);
    }

    @GetMapping("/article/delete/{id}")
    public String modifyArticle(@PathVariable("id") Long id) {
        this.articleService.delete(id);

        return "redirect:/article/list";
    }
}




package com.project._tteockgi.domain.article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {
    @GetMapping("/article")
    @ResponseBody
    public String index(){
        return "article";
    }
}

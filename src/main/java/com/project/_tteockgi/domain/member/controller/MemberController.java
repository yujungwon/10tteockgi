package com.project._tteockgi.domain.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    @GetMapping("/member")
    @ResponseBody
    public String index(){
        return "member";
    }
}

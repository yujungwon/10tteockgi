package com.project._tteockgi.domain.main.controller;

//import com.sun.tools.javac.Main;
import com.project._tteockgi.domain.main.entity.Main;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;


import java.util.List;


//@Controller
//public class MainController {
//    @GetMapping("/")
////    @ResponseBody
//    public String index () {
//
//        return "main";
//    }





@RequiredArgsConstructor
@Controller
public class MainController{
    @GetMapping("/")
//    @ResponseBody
    public String index () {

        return "main";
    }

    private final MainRepository mainRepository;

    @GetMapping("/10tteockgi/main")
    public String list(Model model) {
        List<Main> mainList = this.mainRepository.findAll();
        model.addAttribute("mainlist", mainList);
        return "main_list";
    }
    @GetMapping(value = "/main/detail/")
    public String detail(Model model, @PathVariable("id") Integer id) {
        return "main_detail";
    }
}



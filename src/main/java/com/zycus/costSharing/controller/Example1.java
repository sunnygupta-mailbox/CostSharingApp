package com.zycus.costSharing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Example1 {


    @RequestMapping("/try1")
    public String mainpage1(Model model) {

        model.addAttribute("title","Hello World!");
        return "try";
    }

}

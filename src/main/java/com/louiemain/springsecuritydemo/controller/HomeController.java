package com.louiemain.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 主页
 */
@Controller
public class HomeController {

    @GetMapping("login")
    public String login() {
        return "/login";
    }

    @GetMapping({"index","","/"})
    public String index() {
        return "/index";
    }
}

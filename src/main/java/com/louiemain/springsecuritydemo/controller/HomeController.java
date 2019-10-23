package com.louiemain.springsecuritydemo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sun.plugin.liveconnect.SecurityContextHelper;

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
    public String index(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if ("anonymousUser".equals(principal)) {
            model.addAttribute("name", "anonymous");
        } else {
            User user = (User) principal;
            model.addAttribute("name", user.getUsername());
        }
        return "/index";
    }
}

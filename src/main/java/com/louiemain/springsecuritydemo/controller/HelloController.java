package com.louiemain.springsecuritydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description 测试
 * @Author louiema1n
 * @Date 2019/10/22 16:12
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getWelcomeMsg() {
        return "Hello, SpringSecurity.";
    }

    @GetMapping("admin")
    @PreAuthorize(value = "hasAnyRole('admin')")
    public String helloAdmin() {
        return "Hello, admin";
    }

    @GetMapping("user")
    @PreAuthorize(value = "hasAnyRole('normal')")
    public String helloUser() {
        return "Hello, normal";
    }
}
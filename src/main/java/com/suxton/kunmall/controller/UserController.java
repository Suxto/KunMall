package com.suxton.kunmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:Home";
    }
    @GetMapping("/Home")
    public String home(){
        return "Home";
    }
}

package com.suxton.kunmall.controller;

import com.suxton.kunmall.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:Home";
    }

    @GetMapping("/Home")
    public String home() {
        return "Home";
    }

}

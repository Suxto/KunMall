package com.suxton.kunmall.controller;

import com.suxton.kunmall.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/Home";
    }

    @GetMapping("/Home*")
    public String home() {
        return "user/Home";
    }

    @GetMapping("/Login*")
    public String loginForm() {
        return "user/Login";
    }


    @GetMapping("/Order*")
    public String order() {
        return "user/Order";
    }

    @GetMapping("/Customize*")
    public String customize() {
        return "user/Customize";
    }

    @GetMapping("/ShopMall*")
    public String shopMall() {
        return "user/ShopMall";
    }

    @GetMapping("/Checkout*")
    public String checkout() {
        return "user/Checkout";
    }

}

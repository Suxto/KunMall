package com.suxton.kunmall.controller;

import com.suxton.kunmall.pojo.Recommends;
import com.suxton.kunmall.pojo.RecommendsExample;
import com.suxton.kunmall.service.HardwareService;
import com.suxton.kunmall.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    private final HardwareService hardwareService;

    @Autowired
    public UserController(UserService userService, HardwareService hardwareService) {
        this.userService = userService;
        this.hardwareService = hardwareService;
    }


    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/Home";
    }

    @GetMapping("/Home*")
    public String home(Model model) {
        List<String[]> resolvedRecommendsList = hardwareService.getResolvedRecommendsList();
        model.addAttribute("RecommendsList", resolvedRecommendsList);
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

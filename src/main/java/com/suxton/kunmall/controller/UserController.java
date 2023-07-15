package com.suxton.kunmall.controller;

import com.suxton.kunmall.pojo.Recommends;
import com.suxton.kunmall.pojo.RecommendsExample;
import com.suxton.kunmall.service.HardwareService;
import com.suxton.kunmall.service.Impl.HardwareServiceImpl;
import com.suxton.kunmall.service.UserService;
import com.suxton.kunmall.utils.MyUserDetails;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    private final HardwareService hardwareService;

    private void userInfoSetter(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof String)) {
            MyUserDetails userDetails = (MyUserDetails) principal;
            String username = userDetails.getUsername();
            model.addAttribute("username", username);
            if (userDetails.isAdmin()) {
                model.addAttribute("admin", true);
            } else model.addAttribute("admin", false);
        }
    }

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
        userInfoSetter(model);
        List<String[]> resolvedRecommendsList = hardwareService.getResolvedRecommendsList();
        model.addAttribute("RecommendsList", resolvedRecommendsList);
        return "user/Home";
    }

    @GetMapping("/Login*")
    public String loginForm() {
        return "user/Login";
    }

    @GetMapping("/Register*")
    public String registerForm() {
        return "user/Register";
    }

    @PostMapping("/Register*")
    public String register(@RequestParam(value = "username") String username, @RequestParam(value =
            "password") String passwd) {
        if (userService.hasUser(username)) {
            return "redirect:/Register?error";
        } else {
            userService.createUser(username, passwd);
            return "redirect:/Login";
        }
    }

    @GetMapping("/Order*")
    public String order() {
        return "user/Order";
    }

    @GetMapping("/Customize*")
    public String customize(@RequestParam(defaultValue = "0", value = "recommend") String num, Model model) {
        userInfoSetter(model);

        if ("0".equals(num)) {

        }
        return "user/Customize";
    }

    @GetMapping("/ShopMall*")
    public String shopMall(Model model) {
        userInfoSetter(model);
        return "user/ShopMall";
    }

    @GetMapping("/Checkout*")
    public String checkout() {
        return "user/Checkout";
    }

}

package com.suxton.kunmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/AdminHome*")
    public String adminHome() {
        return "/admin/AdminHome";
    }
    @GetMapping("/Initial*")
    public String initialPage() {
        return "/admin/Initial";
    }
}

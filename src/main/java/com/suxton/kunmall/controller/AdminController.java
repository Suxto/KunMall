package com.suxton.kunmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/Admin/AdminHome*")
    public String adminHome() {
        return "/admin/AdminHome";
    }

}

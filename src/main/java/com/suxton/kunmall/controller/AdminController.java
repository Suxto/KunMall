package com.suxton.kunmall.controller;

import com.suxton.kunmall.pojo.UserConsumed;
import com.suxton.kunmall.service.HardwareService;
import com.suxton.kunmall.service.OrderService;
import com.suxton.kunmall.service.UserService;
import com.suxton.kunmall.utils.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    private final UserService userService;
    private final HardwareService hardwareService;
    private final OrderService orderService;

    @Autowired
    public AdminController(UserService userService, HardwareService hardwareService,
                           OrderService orderService) {
        this.userService = userService;
        this.hardwareService = hardwareService;
        this.orderService = orderService;
    }

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


    @GetMapping("/Admin/AdminHome*")
    public String adminHome(Model model) {
        userInfoSetter(model);
        List<UserConsumed> userConsumed = userService.getUserConsumed();
        model.addAttribute("userConsumed", userConsumed);
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("unhandledOrder", orderService.getUnfinishedOrders());
        model.addAttribute("allOrder", orderService.getAllOrders());
        return "/admin/AdminHome";
    }

    @PostMapping("/Admin/ChangeRole")
    public String changeRole(@RequestParam("id") int id) {
        userService.changeRole(id);
        return "redirect:/Admin/AdminHome";
    }

    @PostMapping("/Admin/ChangePassword")
    public String changePassword(@RequestParam("id") int id, @RequestParam("password") String password) {
        userService.updatePassword(id, password);
        return "redirect:/Admin/AdminHome";
    }

}

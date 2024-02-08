package com.suxton.kunmall.controller;

import com.suxton.kunmall.pojo.UserConsumed;
import com.suxton.kunmall.service.HardwareService;
import com.suxton.kunmall.service.OrderService;
import com.suxton.kunmall.service.UserService;
import com.suxton.kunmall.utils.MyUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class AdminController {
    private final UserService userService;
    private final HardwareService hardwareService;
    private final OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

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

    @GetMapping("/Admin/Store*")
    public String store(Model model) {
        userInfoSetter(model);
        model.addAttribute("CPUList", hardwareService.getCPUList());
        model.addAttribute("GPUList", hardwareService.getGPUList());
        model.addAttribute("MemoryList", hardwareService.getMemoryList());
        model.addAttribute("DriveList", hardwareService.getDriveList());
        return "/admin/Store";
    }

    @PostMapping("/Admin/UpdateComponent")
    public String update(@RequestParam("type") String type, @RequestParam("id") int id, @RequestParam(
            "price") double price, @RequestParam("amount") int amount) {
        if ("CPU".equals(type)) {
            hardwareService.updateCPU(id, price, amount);
        } else if ("GPU".equals(type)) {
            hardwareService.updateGPU(id, price, amount);
        } else if ("Memory".equals(type)) {
            hardwareService.updateMemory(id, price, amount);
        } else if ("Drive".equals(type)) {
            hardwareService.updateDrive(id, price, amount);
        }
        return "redirect:/Admin/Store";
    }

    @PostMapping("/Admin/DeleteComponent")
    public String delete(@RequestParam("type") String type, @RequestParam("id") int id) {
        if ("CPU".equals(type)) {
            hardwareService.deleteCPU(id);
        } else if ("GPU".equals(type)) {
            hardwareService.deleteGPU(id);
        } else if ("Memory".equals(type)) {
            hardwareService.deleteMemory(id);
        } else if ("Drive".equals(type)) {
            hardwareService.deleteDrive(id);
        }
        return "redirect:/Admin/Store";
    }

    @PostMapping("/Admin/AddComponent")
    public String add(@RequestParam("type") String type, @RequestParam("name") String name, @RequestParam(
            "price") double price, @RequestParam("amount") int amount) {
        if ("CPU".equals(type)) {
            hardwareService.addCPU(name, price, amount);
        } else if ("GPU".equals(type)) {
            hardwareService.addGPU(name, price, amount);
        } else if ("Memory".equals(type)) {
            hardwareService.addMemory(name, price, amount);
        } else if ("Drive".equals(type)) {
            hardwareService.addDrive(name, price, amount);
        }
        return "redirect:/Admin/Store";
    }

    @GetMapping("/Admin/OrderDeal*")
    public String orderDealPage(Model model) {
        userInfoSetter(model);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        MyUserDetails userDetails = (MyUserDetails) principal;
        int id = userDetails.id();
        model.addAttribute("orders", orderService.getAllOrders());
        return "/admin/OrderDeal";
    }

    @PostMapping("/Admin/ChangeStatus")
    public String changeStatus(@RequestParam("id") int id, @RequestParam("status") String status) {
        orderService.updateStatusByID(id, status);
        return "redirect:/OrderDeal";
    }

    @GetMapping("/Admin/Help*")
    public String helpPage(Model model, @RequestParam("username") String username,
                           @RequestParam("id") int id) {
        userInfoSetter(model);
        model.addAttribute("username", username);
        model.addAttribute("id", id);
        model.addAttribute("text", userService.getHelpText(id, (short) 1));
        return "admin/Help";
    }

    @ResponseBody
    @PostMapping("/Admin/Reply")
    public String replyUserHelp(@RequestParam("id") int id,
                                @RequestParam("content") String content) {
        userService.addHelpText(id, "Admin: " + content, (short) 1, null);
        return "ok";
    }

    @GetMapping("/Admin/AdminHelp*")
    public String adminHelpPage(Model model) {
        userInfoSetter(model);
        model.addAttribute("List", userService.getServiceList());
        return "/admin/AdminHelp";
    }

    @GetMapping("/Admin/RecommendationEditor*")
    public String RecommendationEditor(Model model) {
        List<String[]> resolvedRecommendsList = hardwareService.getResolvedRecommendsList();
        model.addAttribute("RecommendsList", resolvedRecommendsList);
        return "/admin/RecommendationEditor";
    }

}

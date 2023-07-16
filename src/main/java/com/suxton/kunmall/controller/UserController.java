package com.suxton.kunmall.controller;

import com.suxton.kunmall.pojo.Orders;
import com.suxton.kunmall.pojo.Recommends;
import com.suxton.kunmall.pojo.RecommendsExample;
import com.suxton.kunmall.service.HardwareService;
import com.suxton.kunmall.service.Impl.HardwareServiceImpl;
import com.suxton.kunmall.service.UserService;
import com.suxton.kunmall.utils.MyUserDetails;
import com.suxton.kunmall.utils.OrderData;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

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
        List<String[]> cpuInfoList = hardwareService.getCPUInfoList();
        model.addAttribute("CPUList", cpuInfoList);
        List<String[]> gpuInfoList = hardwareService.getGPUInfoList();
        model.addAttribute("GPUList", gpuInfoList);
        List<String[]> memoryInfoList = hardwareService.getMemoryInfoList();
        model.addAttribute("MemoryList", memoryInfoList);
        List<String[]> driveInfoList = hardwareService.getDriveInfoList();
        model.addAttribute("DriveList", driveInfoList);
        HashMap<String, Integer> details;
        if (!"0".equals(num)) {
            details = hardwareService.getRecommendDetail(Integer.parseInt(num));
        } else details = new HashMap<>();
        model.addAttribute("details", details);
        return "user/Customize";
    }


    @PostMapping("/SubmitOrder*")
    public String submitOrder(@RequestParam("CPUName") String cpuName,
                              @RequestParam("GPUName") String gpuName,
                              @RequestParam("MemoryName") String memoryName,
                              @RequestParam("DriveName") String driveName,
                              @RequestParam("sum") double sum,
                              @RequestParam("address") String address,
                              @RequestParam("comment") String comment) {

        Orders orders = new Orders();
        orders.setCpuname(cpuName);
        orders.setGpuname(gpuName);
        orders.setDrivename(driveName);
        orders.setMemoryname(memoryName);
        orders.setMoney(BigDecimal.valueOf(sum));
        orders.setAddress(address);
        orders.setComment(comment);
        orders.setOrdertime(new Date());
        orders.setStatus("未发货");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        MyUserDetails userDetails = (MyUserDetails) principal;

        orders.setUserid(userDetails.id());
        userService.createOrder(orders);
        return "redirect:/Order";
    }

    @GetMapping("/Checkout*")
    public String checkout(@RequestParam("CPUName") String cpuName,
                           @RequestParam("CPUPrice") String cpuPrice,
                           @RequestParam("GPUName") String gpuName,
                           @RequestParam("GPUPrice") String gpuPrice,
                           @RequestParam("MemoryName") String memoryName,
                           @RequestParam("MemoryPrice") String memoryPrice,
                           @RequestParam("DriveName") String driveName,
                           @RequestParam("DrivePrice") String drivePrice, @RequestParam("sum") String sum,
                           Model model) {
        model.addAttribute("CPUName", cpuName);
        model.addAttribute("CPUPrice", cpuPrice);
        model.addAttribute("GPUName", gpuName);
        model.addAttribute("GPUPrice", gpuPrice);
        model.addAttribute("MemoryName", memoryName);
        model.addAttribute("MemoryPrice", memoryPrice);
        model.addAttribute("DriveName", driveName);
        model.addAttribute("DrivePrice", drivePrice);
        model.addAttribute("sum", sum);
        return "user/Checkout";
    }

}

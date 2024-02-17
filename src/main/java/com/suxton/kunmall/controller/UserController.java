package com.suxton.kunmall.controller;

import com.suxton.kunmall.pojo.Comment;
import com.suxton.kunmall.pojo.Moment;
import com.suxton.kunmall.pojo.MomentWithPhoto;
import com.suxton.kunmall.pojo.Orders;
import com.suxton.kunmall.service.HardwareService;
import com.suxton.kunmall.service.MomentService;
import com.suxton.kunmall.service.UserService;
import com.suxton.kunmall.utils.MyUserDetails;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
//    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    private final HardwareService hardwareService;


    private final MomentService momentService;


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
            model.addAttribute("unread", userService.isUnread(userDetails.id()));
        }

    }

    @Autowired
    public UserController(UserService userService, HardwareService hardwareService
            , MomentService momentService) {
        this.userService = userService;
        this.hardwareService = hardwareService;
        this.momentService = momentService;
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

    @GetMapping("/KunMoment*")
    public String moment(Model model) {
        userInfoSetter(model);
        List<MomentWithPhoto> moments = momentService.getMoments();
        model.addAttribute("MomentList", moments);
        return "user/KunMoment";
    }

    @ResponseBody
    @PostMapping("/UploadKunMomentMetaData")
    public String uploadKunMomentMetaData(@RequestParam("text") String text) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        MyUserDetails userDetails = (MyUserDetails) principal;
        int idx = momentService.addMoment(userDetails.getUsername(), userDetails.id(), text);
        return String.valueOf(idx);
    }

    @ResponseBody
    @PostMapping("/UploadKunMomentPhoto")
    public String uploadKunMomentPhoto(@RequestParam("file") MultipartFile file,
                                       @RequestParam("id") int momentID) {
        try {
            if (!file.isEmpty()) {
                // Get bytes from the file
                byte[] bytes = file.getBytes();
                momentService.addPhoto(momentID, bytes);
            } else {
                return "Failed to upload image. File is empty.";
            }
        } catch (Exception e) {
//            e.printStackTrace();
            return "Failed to upload image. Error: " + e.getMessage();
        }
        return "ok";
    }

    @ResponseBody
    @GetMapping("/getComments")
    public List<Comment> getComments(@RequestParam("moment_id") int id) {
        return momentService.getCommentList(id);
    }

    @ResponseBody
    @PostMapping("/addComment")
    public String addComment(@RequestParam("moment_id") int momentID,
                             @RequestParam("content") String content) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        MyUserDetails userDetails = (MyUserDetails) principal;
        momentService.addComment(userDetails.id(), userDetails.getUsername(), momentID, content);
        return "ok";
    }

    @ResponseBody
    @PostMapping("/likeMoment")
    public int likeMoment(@RequestParam("moment_id") int momentID) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        MyUserDetails userDetails = (MyUserDetails) principal;
        return momentService.like(userDetails.id(), momentID);
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
    public String order(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        MyUserDetails userDetails = (MyUserDetails) principal;
        userInfoSetter(model);

        model.addAttribute("orders", userService.getUserOrderList(userDetails.id()));
        return "user/Order";
    }

    @GetMapping("/Customize*")
    public String customize(@RequestParam(defaultValue = "0", value = "recommend") int num, Model model) {
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
        if (0 != num) {
            System.out.println(num);
            details = hardwareService.getRecommendDetail(num);
        } else details = new HashMap<>();
        model.addAttribute("details", details);
        return "user/Customize";
    }


    @PostMapping("/SubmitOrder*")
    public String submitOrder(@RequestParam("CPUName") String cpuName,
                              @RequestParam("GPUName") String gpuName,
                              @RequestParam("MemoryName") String memoryName,
                              @RequestParam("DriveName") String driveName, @RequestParam("sum") double sum,
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

    @GetMapping("/Help*")
    public String helpForm(Model model) {
        userInfoSetter(model);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        MyUserDetails userDetails = (MyUserDetails) principal;
        Integer id = userDetails.id();
        String helpText = userService.getHelpText(id, (short) 2);
        model.addAttribute("text", helpText);
        model.addAttribute("unread", false);
        return "user/Help";
    }

    @PostMapping("/SendMsg")
    public String sendMsg(@RequestParam("content") String content) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        MyUserDetails userDetails = (MyUserDetails) principal;
        Integer id = userDetails.id();
        String username = userDetails.getUsername();
        userService.addHelpText(id, username + ": " + content, (short) 2, username);
        return "redirect:/Help";
    }
}

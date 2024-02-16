package com.suxton.kunmall.controller;

import com.suxton.kunmall.dao.RecommendsMapper;
import com.suxton.kunmall.pojo.Recommends;
import com.suxton.kunmall.pojo.UserConsumed;
import com.suxton.kunmall.service.HardwareService;
import com.suxton.kunmall.service.MomentService;
import com.suxton.kunmall.service.OrderService;
import com.suxton.kunmall.service.UserService;
import com.suxton.kunmall.utils.MyUserDetails;
import lombok.extern.slf4j.Slf4j;
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

import java.util.HashMap;
import java.util.List;


@Controller
@Slf4j
public class AdminController {
    private final UserService userService;
    private final HardwareService hardwareService;
    private final OrderService orderService;
    private final MomentService momentService;
    private final RecommendsMapper recommendsMapper;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    public AdminController(UserService userService, HardwareService hardwareService,
                           OrderService orderService, MomentService momentService,
                           RecommendsMapper recommendsMapper) {
        this.userService = userService;
        this.hardwareService = hardwareService;
        this.orderService = orderService;
        this.momentService = momentService;
        this.recommendsMapper = recommendsMapper;
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
    public String recommendationEditor(Model model) {
        List<String[]> resolvedRecommendsList = hardwareService.getResolvedRecommendsList();
        model.addAttribute("RecommendsList", resolvedRecommendsList);
        return "/admin/RecommendationEditor";
    }

    @GetMapping("/Admin/RecommendationAdd*")
    public String recommendationAdd(@RequestParam(defaultValue = "0", value = "recommend") String num,Model model) {
        userInfoSetter(model);

        List<String[]> resolvedRecommendsList = hardwareService.getResolvedRecommendsList();
        String comment = "请在此添加说明...";
        model.addAttribute("comment", comment);

        List<String[]> cpuInfoList = hardwareService.getCPUInfoList();
        model.addAttribute("CPUList", cpuInfoList);
        log.info(cpuInfoList.toString());
        List<String[]> gpuInfoList = hardwareService.getGPUInfoList();
        model.addAttribute("GPUList", gpuInfoList);
        List<String[]> memoryInfoList = hardwareService.getMemoryInfoList();
        model.addAttribute("MemoryList", memoryInfoList);
        List<String[]> driveInfoList = hardwareService.getDriveInfoList();
        model.addAttribute("DriveList", driveInfoList);

        HashMap<String, Integer> details;
        if (!"0".equals(num)) {
            details = hardwareService.getRecommendDetail(Integer.parseInt(num));
            recommendID = Integer.parseInt(num);
        } else details = new HashMap<>();
        model.addAttribute("details", details);

        return "/admin/RecommendationAdd";
    }


    public Integer recommendID = -1;

    @GetMapping("/Admin/RecommendationEdit*")
    public String recommendationEdit(@RequestParam(defaultValue = "0", value = "recommend") String num, Model model) {
        userInfoSetter(model);
        log.info("num: " + num);
        List<String[]> resolvedRecommendsList = hardwareService.getResolvedRecommendsList();
        String comment = resolvedRecommendsList.stream()
                .filter(item -> Integer.parseInt(item[6]) == Integer.parseInt(num))
                .findFirst()
                .map(item -> item[5])
                .orElse("请在此添加说明...");
        log.info(comment);
        model.addAttribute("comment", comment);

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
            recommendID = Integer.parseInt(num);
        } else details = new HashMap<>();
        model.addAttribute("details", details);
        return "/admin/RecommendationEdit";
    }

    @GetMapping("/Admin/RecommendationDelete*")
    public String deleteRecommendation(@RequestParam("recommend") Integer recommendId) {
        recommendsMapper.deleteByPrimaryKey(recommendId);
        log.info("recommendId: " + recommendId);
        return "redirect:/Admin/RecommendationEditor";
    }

    @PostMapping("/Admin/AddRecommendation")
    public String addCommends(@RequestParam("cpuID") int cpuID,
                              @RequestParam("gpuID") int gpuID,
                              @RequestParam("memoryID") int memoryID,
                              @RequestParam("driveID") int driveID,
                              @RequestParam("comment") String comment) {
        Recommends recommends = new Recommends();
        recommends.setCpuid(cpuID);
        recommends.setGpuid(gpuID);
        recommends.setMemoryid(memoryID);
        recommends.setDriveid(driveID);
        recommends.setComment(comment);
        recommendsMapper.insert(recommends);
        return "redirect:/Admin/RecommendationEditor";
    }


    @PostMapping("/Admin/SubmitRecommendation")
    public String submitCommends(@RequestParam("cpuID") int cpuID,
                                 @RequestParam("gpuID") int gpuID,
                                 @RequestParam("memoryID") int memoryID,
                                 @RequestParam("driveID") int driveID,
                                 @RequestParam("comment") String comment) {
        log.info("cpuID: " + cpuID);
        log.info("gpuID: " + gpuID);
        log.info("memoryID: " + memoryID);
        log.info("driveID: " + driveID);
        log.info("comment: " + comment);
        if (recommendID != -1) {
            Recommends recommends = new Recommends();
            recommends.setId(recommendID);
            recommends.setCpuid(cpuID);
            recommends.setGpuid(gpuID);
            recommends.setMemoryid(memoryID);
            recommends.setDriveid(driveID);
            recommends.setComment(comment);
            recommendsMapper.updateByPrimaryKeySelective(recommends);
        }
        return "redirect:/Admin/RecommendationEditor";
    }

    @ResponseBody
    @PostMapping("/Admin/RemoveMoment*")
    public String removeMoment(@RequestParam("moment_id") int momentID) {
        momentService.removeMoment(momentID);
        return "ok";
    }
}

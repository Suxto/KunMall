package com.suxton.kunmall;

import com.suxton.kunmall.service.HardwareService;
import com.suxton.kunmall.service.UserService;
import com.suxton.kunmall.pojo.UserConsumed;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KunMallApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    HardwareService hardwareService;

    @Test
    void userServiceTest() {
//        userService.createUser("Suxton", "1234");
        hardwareService.addCPU("i5-13500", 1500, 20);
    }

}

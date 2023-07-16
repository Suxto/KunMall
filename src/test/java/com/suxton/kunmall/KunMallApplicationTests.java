package com.suxton.kunmall;

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

    @Test
    void userServiceTest() {
//        userService.createUser("Suxton", "1234");
        List<UserConsumed> userConsumed = userService.getUserConsumed();
        for (UserConsumed consumedInfo : userConsumed) {
            System.out.println(consumedInfo.getUserID());
            System.out.println(consumedInfo.getMoney());
            System.out.println(consumedInfo.getConsumeTime());
            System.out.println(consumedInfo.getUserName());
            System.out.println(consumedInfo.getLatestOrder());
        }
    }

}

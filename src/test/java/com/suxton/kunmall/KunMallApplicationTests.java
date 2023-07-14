package com.suxton.kunmall;

import com.suxton.kunmall.pojo.User;
import com.suxton.kunmall.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KunMallApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void userServiceTest() {
        User user = new User();
        user.setIsadmin(false);
        user.setUsername("Suxton");
        user.setPasswd("1234");
        userService.createUser(user);
    }

}

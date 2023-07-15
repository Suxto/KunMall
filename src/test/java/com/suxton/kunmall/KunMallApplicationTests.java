package com.suxton.kunmall;

import com.suxton.kunmall.pojo.User;
import com.suxton.kunmall.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class KunMallApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void userServiceTest() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        userService.createUser("Suxton", bCryptPasswordEncoder.encode("1234"));
    }

}

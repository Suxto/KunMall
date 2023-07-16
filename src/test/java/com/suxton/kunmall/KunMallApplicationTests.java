package com.suxton.kunmall;

import com.suxton.kunmall.pojo.User;
import com.suxton.kunmall.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;

@SpringBootTest
class KunMallApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void userServiceTest() {
//        userService.createUser("Suxton", "1234");
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(map.get("hello"));
    }
}

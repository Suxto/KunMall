package com.suxton.kunmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.suxton.kunmall.dao")
public class KunMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(KunMallApplication.class, args);
    }

}

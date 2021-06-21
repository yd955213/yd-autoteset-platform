package com.yd.autotestplatform.ums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yd.autotestplatform.ums.mapper")
public class YdAutotestUmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(YdAutotestUmsApplication.class, args);
    }

}

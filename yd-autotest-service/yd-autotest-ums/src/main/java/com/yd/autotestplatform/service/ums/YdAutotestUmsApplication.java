package com.yd.autotestplatform.service.ums;

import com.yd.autotestplatform.service.ums.entity.UmsMember;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@MapperScan("com.yd.autotestplatform.ums.mapper")
public class YdAutotestUmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(YdAutotestUmsApplication.class, args);
    }

    /**
     * 使用spring bean工厂初始化BCryptPasswordEncoder，获取单例对象
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UmsMember UmsMember(){ return  new UmsMember(); }
}

package com.yd.autotestplatform.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication(scanBasePackages={"com.yd"})
public class  PortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }
}

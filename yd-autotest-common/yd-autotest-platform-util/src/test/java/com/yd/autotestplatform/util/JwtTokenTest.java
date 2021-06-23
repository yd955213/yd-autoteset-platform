package com.yd.autotestplatform.util;

import io.jsonwebtoken.ExpiredJwtException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>
 *
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-23 8:56
 * @Email: 664720125@qq.com
 */
@SpringBootTest
class JwtTokenTest {

    @Test
    void creatToken() throws InterruptedException {
        // 设置token 5s 过期
        JwtToken.setExpiration(5000L);
        String subject = "测试123";

        String token = JwtToken.creatToken(subject);
        Thread.sleep(1000);
        System.out.println("token = " + token);
        String token_1 = JwtToken.creatToken(subject);
        System.out.println("token_1 = " + token_1);
        // 验证相隔1s生成的签名不一样 : jwt 使用的时间戳是以秒为单位，同一秒下的token是一致的
        assertNotEquals(token, token_1);

        String parseToken = JwtToken.parseToken(token);
        // 验证加解密的主题是一样的，即 tonken解密成功
        assertEquals(subject, parseToken);

        Thread.sleep(6000);
//        断言token过期，需要使用测试用的 5s 过期时间， 默认30分钟过期
        assertThrows(ExpiredJwtException.class, ()->{
            JwtToken.parseToken(token);
        });
    }

    @Test
    void parseToken() throws UnsupportedEncodingException {
        String subject = "测试123";
        String token = JwtToken.creatToken(subject);
        String[] tokenList = token.split("\\.");
        System.out.println(token);
        for (String a :tokenList ){
            System.out.println(a);
        }
        byte[] heard = Base64.getDecoder().decode(tokenList[0].getBytes(StandardCharsets.UTF_8));
//        byte[] payload = Base64.getDecoder().decode(tokenList[1].getBytes(StandardCharsets.UTF_8));

        System.out.println(new String(heard, "utf-8"));
//        System.out.println(new String(payload, "utf-8"));
    }
}

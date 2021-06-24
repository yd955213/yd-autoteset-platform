package com.yd.autotestplatform.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>
 *
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-24 11:31
 * @Email: 664720125@qq.com
 */
class RandomStringUtilsTest {

    @Test
    void getUUID() {
        String s = RandomStringUtils.getUUID();
        System.out.println(s);
        System.out.println(s.length());
    }

    @Test
    void getRandomPRC() {
        String randomPRC = RandomStringUtils.getRandomPRC();
        System.out.println(randomPRC);
        System.out.println(randomPRC.length());

    }

    @Test
    void testGetRandomPRC() {
        String sourceString = "ABCD123456789";
        String randomPRC1 = RandomStringUtils.getRandomPRC(sourceString);
        System.out.println(randomPRC1);
        System.out.println(randomPRC1.length());
    }

    @Test
    void getRandomInt() {
        Integer randomInt = RandomStringUtils.getRandomInt(10, 30);
        System.out.println(randomInt);
    }

    @Test
    void getRandomString() {
        String randomString = RandomStringUtils.getRandomString(20);
        System.out.println(randomString);
        System.out.println(randomString.length());
    }
}

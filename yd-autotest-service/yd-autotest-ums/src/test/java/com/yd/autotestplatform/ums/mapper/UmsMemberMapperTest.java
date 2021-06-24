package com.yd.autotestplatform.ums.mapper;

import com.yd.autotestplatform.ums.entity.UmsMember;
import com.yd.autotestplatform.ums.entity.dto.UmsMemberLoginParamDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>
 *
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-21 14:30
 * @Email: 664720125@qq.com
 */
@SpringBootTest
class UmsMemberMapperTest {
    @Autowired
    UmsMemberMapper umsMemberMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void selectByName() {
        UmsMemberLoginParamDTO umsMemberLoginParamDTO = new UmsMemberLoginParamDTO();
        umsMemberLoginParamDTO.setUsername("yd");
        umsMemberLoginParamDTO.setPassword("123");
        UmsMember umsMember = umsMemberMapper.selectById(68L);
        umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUsername());
        System.out.println(umsMember);
    }

    @Test
    void testScrypt(){
        String st = "123456";
        String encode1 = passwordEncoder.encode(st);
        System.out.println(encode1);
        String encode2 = passwordEncoder.encode(st);
        System.out.println(encode2);
        System.out.println(passwordEncoder.matches(st, encode1));
        System.out.println(passwordEncoder.matches(st, encode2));
        System.out.println(passwordEncoder.matches("123455", encode2));

    }
}

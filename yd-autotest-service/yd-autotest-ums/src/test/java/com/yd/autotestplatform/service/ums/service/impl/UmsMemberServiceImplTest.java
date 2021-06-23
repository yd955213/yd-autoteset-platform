package com.yd.autotestplatform.service.ums.service.impl;

import com.yd.autotestplatform.base.result.ResultWrapper;
import com.yd.autotestplatform.service.ums.entity.UmsMember;
import com.yd.autotestplatform.service.ums.entity.dto.UmsMemberLoginParamDTO;
import com.yd.autotestplatform.service.ums.mapper.UmsMemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UmsMemberServiceImplTest {
    @Autowired
    UmsMemberMapper umsMemberMapper;
    @Autowired
    UmsMemberServiceImpl umsMemberServiceImpl;

    @Test
    void testInsert(){
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername("yd");
        umsMember.setPassword("123");

        umsMemberMapper.insert(umsMember);
    }

    @Test
    void login() {
        UmsMemberLoginParamDTO umsMemberLoginParamDTO = new UmsMemberLoginParamDTO();
        umsMemberLoginParamDTO.setUserName("yd");
        umsMemberLoginParamDTO.setPassWord("123456");
        ResultWrapper<String> login = umsMemberServiceImpl.login(umsMemberLoginParamDTO);
        System.out.println(login);
    }
}

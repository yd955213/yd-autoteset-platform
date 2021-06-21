package com.yd.autotestplatform.ums.service.impl;

import com.yd.autotestplatform.ums.entity.UmsMember;
import com.yd.autotestplatform.ums.mapper.UmsMemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UmsMemberServiceImplTest {
    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Test
    void testInsert(){
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername("yd");
        umsMember.setPassword("123");

        umsMemberMapper.insert(umsMember);
    }
}

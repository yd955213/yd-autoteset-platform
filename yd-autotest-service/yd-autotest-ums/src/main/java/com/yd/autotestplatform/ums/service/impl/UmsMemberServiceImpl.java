package com.yd.autotestplatform.ums.service.impl;

import com.yd.autotestplatform.ums.entity.UmsMember;
import com.yd.autotestplatform.ums.mapper.UmsMemberMapper;
import com.yd.autotestplatform.ums.service.UmsMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author yangdang
 * @since 2021-06-21
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {
    @Autowired
    UmsMemberMapper umsMemberMapper;

    public String register(){

        UmsMember umsMember = new UmsMember();
        umsMember.setUsername("yd");
        umsMember.setEmail("yd@163.com");
        umsMember.setPassword("123");
        umsMember.setStatus(1);
        umsMemberMapper.insert(umsMember);
        return umsMember.toString();
    }

    public String login(){
        return "login success";
    }

    public String logout(){
        return "logout success";
    }
}

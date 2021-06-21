package com.yd.autotestplatform.ums.service.impl;

import com.yd.autotestplatform.ums.entity.UmsMember;
import com.yd.autotestplatform.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.yd.autotestplatform.ums.mapper.UmsMemberMapper;
import com.yd.autotestplatform.ums.service.UmsMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    PasswordEncoder passwordEncoder;

    public String register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){

        UmsMember umsMember = new UmsMember();
        // 将umsMemberRegisterParamDTO的属性值传递给umsMember
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);
        // 使用BCryptPasswordEncoder 加密密码后写库 这种方法不常用，
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode(umsMember.getPassword());
        // spring 常用写法
        String encode = passwordEncoder.encode(umsMember.getPassword());
        umsMember.setPassword(encode);
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

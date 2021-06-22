package com.yd.autotestplatform.ums.service.impl;

import com.yd.autotestplatform.base.result.ResultWrapper;
import com.yd.autotestplatform.ums.entity.UmsMember;
import com.yd.autotestplatform.ums.entity.dto.UmsMemberLoginParamDTO;
import com.yd.autotestplatform.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.yd.autotestplatform.ums.mapper.UmsMemberMapper;
import com.yd.autotestplatform.ums.service.UmsMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;

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

    public ResultWrapper<String>  register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){

        UmsMember umsMember = new UmsMember();
        // 将umsMemberRegisterParamDTO的属性值传递给umsMember
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);
        // 使用BCryptPasswordEncoder 加密密码后写库 这种方法不常用，
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode(umsMember.getPassword());
        // spring 常用写法
        String encode = passwordEncoder.encode(umsMember.getPassword());
        umsMember.setPassword(encode);
//        try {
        umsMemberMapper.insert(umsMember);
        return ResultWrapper.getSuccessBuilder().data("注册成功").build();
//        }catch (Exception e){
//            return ResultWrapper.getFailBuilder().data("用户名已存在").build();
//        }
    }

    public ResultWrapper<String> login(UmsMemberLoginParamDTO umsMemberLoginParamDTO){
        UmsMember umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUserName());
        String data = "";
        if(null != umsMember){
            String passwordInDb = umsMember.getPassword();

            if (!passwordEncoder.matches(umsMemberLoginParamDTO.getPassWord(), umsMember.getPassword())){
                data = "密码错误！";
                return ResultWrapper.getFailBuilder().data(data).build();
            }else {
                data = "登录成功";
                return ResultWrapper.getSuccessBuilder().data(data).build();
            }
        }else {
            data =  "账号不存在！";
            return ResultWrapper.getFailBuilder().data(data).build();
        }
    }

    public String logout(){
        return "logout success";
    }
}

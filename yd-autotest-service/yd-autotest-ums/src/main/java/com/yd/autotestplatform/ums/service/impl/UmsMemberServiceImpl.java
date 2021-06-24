package com.yd.autotestplatform.ums.service.impl;

import com.yd.autotestplatform.ums.entity.response.UmsMemberLoginResponseParam;
import com.yd.autotestplatform.base.enums.StateCodeEnum;
import com.yd.autotestplatform.base.result.ResultWrapper;
import com.yd.autotestplatform.ums.entity.UmsMember;
import com.yd.autotestplatform.ums.entity.dto.UmsMemberLoginParamDTO;
import com.yd.autotestplatform.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.yd.autotestplatform.ums.mapper.UmsMemberMapper;
import com.yd.autotestplatform.ums.UmsMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yd.autotestplatform.util.JwtToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Autowired
    UmsMember umsMember;

    public ResultWrapper<String>  register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){

//        UmsMember umsMember = new UmsMember();
        // 将umsMemberRegisterParamDTO的属性值传递给umsMember
        // BeanUtils.copyProperties 区分大小写， 两个类的参数名必须一样才会赋值，否则为空
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);
        // 使用BCryptPasswordEncoder 加密密码后写库 这种方法不常用，
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode(umsMember.getPassword());
        // spring 常用写法
        String encode = passwordEncoder.encode(umsMember.getPassword());
        umsMember.setPassword(encode);
        umsMemberMapper.insert(umsMember);
        return ResultWrapper.getSuccessBuilder().data("注册成功").build();
    }

    public ResultWrapper<String> login(UmsMemberLoginParamDTO umsMemberLoginParamDTO){
        umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUsername());
        String data = "";
        if(null != umsMember){
            String passwordInDb = umsMember.getPassword();

            if (!passwordEncoder.matches(umsMemberLoginParamDTO.getPassword(), umsMember.getPassword())){
                data = "密码错误！";
                return ResultWrapper.getFailBuilder()
                        .code(StateCodeEnum.PASSWORD_ERROR.getCode())
                        .msg(StateCodeEnum.PASSWORD_ERROR.getMsg())
                        .data(data)
                        .build();
            }
        }else {
            data =  "用户不存在！";
            return ResultWrapper.getFailBuilder()
                    .code(StateCodeEnum.USER_EMPTY.getCode())
                    .msg(StateCodeEnum.USER_EMPTY.getMsg()).data(data).build();
        }

        String token = JwtToken.creatToken(umsMemberLoginParamDTO.getUsername());
        UmsMemberLoginResponseParam umsMemberLoginResponseParam= new UmsMemberLoginResponseParam();
        umsMemberLoginResponseParam.setToken(token);
        umsMember.setPassword("");
        umsMemberLoginResponseParam.setUmsMember(umsMember);

        return ResultWrapper.getSuccessBuilder().data(umsMemberLoginResponseParam).build();
    }

    public ResultWrapper<String> logout(String token){
        String parseToken = JwtToken.parseToken(token);
        System.out.println(token);
        umsMember = umsMemberMapper.selectByName(parseToken);
        umsMember.setLoginTime(new Date());
        umsMemberMapper.updateById(umsMember);
        return ResultWrapper.getSuccessBuilder().data("注销成功").build();
    }

    @Override
    public ResultWrapper<String> edit(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);
        umsMemberMapper.updateById(umsMember);
        return ResultWrapper.getSuccessBuilder().data("更新信息成功").build();
    }


}

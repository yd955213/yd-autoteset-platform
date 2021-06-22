package com.yd.autotestplatform.portal.controller;


import com.yd.autotestplatform.base.result.ResultWrapper;
import com.yd.autotestplatform.ums.entity.UmsMember;
import com.yd.autotestplatform.ums.entity.dto.UmsMemberLoginParamDTO;
import com.yd.autotestplatform.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.yd.autotestplatform.ums.mapper.UmsMemberMapper;
import com.yd.autotestplatform.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author yangdang
 * @since 2021-06-21
 */
@RestController
@RequestMapping("/ums-member")
public class UmsMemberController {

    @Autowired
    UmsMemberService umsMemberService;

    @PostMapping("/register")
    public ResultWrapper<String>  register(@RequestBody UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){

        ResultWrapper<String>  register = umsMemberService.register(umsMemberRegisterParamDTO);

        return register;
    }

    @PostMapping("/login")
    public ResultWrapper<String> login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO){
        ResultWrapper<String> login = umsMemberService.login(umsMemberLoginParamDTO);
        return login;

    }
}


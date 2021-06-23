package com.yd.autotestplatform.portal.controller;


import com.yd.autotestplatform.base.result.ResultWrapper;
import com.yd.autotestplatform.service.ums.entity.dto.UmsMemberLoginParamDTO;
import com.yd.autotestplatform.service.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.yd.autotestplatform.service.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

    @Autowired
    private HttpServletRequest httpServletRequest;


    @PostMapping("/register")
    public ResultWrapper<String>  register(@RequestBody @Valid  UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){

        ResultWrapper<String>  register = umsMemberService.register(umsMemberRegisterParamDTO);

        return register;
    }

    @PostMapping("/login")
    public ResultWrapper<String> login(@RequestBody @Valid UmsMemberLoginParamDTO umsMemberLoginParamDTO){
        System.out.println(umsMemberLoginParamDTO);
        ResultWrapper<String> login = umsMemberService.login(umsMemberLoginParamDTO);
        return login;

    }

    @GetMapping("/logout")
    public ResultWrapper logout(){
        // 删除token
        ResultWrapper<String> logout = umsMemberService.logout("");
        return logout;
    }
    @PutMapping("/edit")
    public ResultWrapper edit(@RequestBody @Valid  UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){
        // 删除token
        ResultWrapper<String> logout = umsMemberService.edit(umsMemberRegisterParamDTO);
        return logout;
    }
}


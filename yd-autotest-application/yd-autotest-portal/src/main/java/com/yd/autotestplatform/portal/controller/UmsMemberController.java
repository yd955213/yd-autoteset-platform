package com.yd.autotestplatform.portal.controller;


import com.yd.autotestplatform.ums.entity.UmsMember;
import com.yd.autotestplatform.ums.mapper.UmsMemberMapper;
import com.yd.autotestplatform.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/register")
    public String register(){
        String register = umsMemberService.register();

        return register;
    }
}


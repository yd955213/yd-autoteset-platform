package com.yd.autotestplatform.service.ums.service;

import com.yd.autotestplatform.base.result.ResultWrapper;
import com.yd.autotestplatform.service.ums.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yd.autotestplatform.service.ums.entity.dto.UmsMemberLoginParamDTO;
import com.yd.autotestplatform.service.ums.entity.dto.UmsMemberRegisterParamDTO;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author yangdang
 * @since 2021-06-21
 */
public interface UmsMemberService extends IService<UmsMember> {
    ResultWrapper<String> register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);
    ResultWrapper<String> login(UmsMemberLoginParamDTO umsMemberLoginParamDTO);
    ResultWrapper<String> logout(String token);
    ResultWrapper<String> edit(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);
}

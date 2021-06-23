package com.yd.autotestplatform.service.ums.entity.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * <p>
 *  前端登录输入
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-21 14:05
 * @Email: 664720125@qq.com
 */
public class UmsMemberLoginParamDTO {
    @Size(min = 1, max = 8, message = "用户名长度在1-8之间")
    @NotEmpty(message = "用户名不能为空")
    public String userName;
    @NotEmpty(message = "密码不能为空")
    @Min(value = 3, message = "密码长度大于2")
    public String passWord;

    @Override
    public String toString() {
        return "UmsMemberLoginParamDTO{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public UmsMemberLoginParamDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public UmsMemberLoginParamDTO setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }
}

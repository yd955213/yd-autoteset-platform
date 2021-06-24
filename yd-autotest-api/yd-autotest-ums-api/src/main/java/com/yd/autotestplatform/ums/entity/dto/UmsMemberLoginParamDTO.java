package com.yd.autotestplatform.ums.entity.dto;

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
    public String username;
    @NotEmpty(message = "密码不能为空")
    @Min(value = 3, message = "密码长度大于2")
    public String password;

    public String getUsername() {
        return username;
    }

    public UmsMemberLoginParamDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UmsMemberLoginParamDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "UmsMemberLoginParamDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

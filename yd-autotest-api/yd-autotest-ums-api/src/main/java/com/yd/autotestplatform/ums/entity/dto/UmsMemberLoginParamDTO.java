package com.yd.autotestplatform.ums.entity.dto;

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
    public String userName;
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

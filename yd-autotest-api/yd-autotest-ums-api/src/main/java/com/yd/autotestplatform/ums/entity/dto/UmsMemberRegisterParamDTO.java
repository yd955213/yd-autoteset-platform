package com.yd.autotestplatform.ums.entity.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-21 12:07
 * @Email: 664720125@qq.com
 */

public class UmsMemberRegisterParamDTO {
    @Size(min = 1, max = 8, message = "用户名长度在1-8之间")
    private String userName;
    @Min(value = 3, message = "密码长度大于2")
    private String passWord;
    private String icon;
    @Pattern(regexp = "^[1][3, 4, 5, 6, 7, 8, 9][0-9]{9}$", message = "手机号格式错误！")
    private String phoneNumber;
    @Email
    private String email;
    private String nickName;
    private String note;

    @Override
    public String toString() {
        return "UmsMemberRegisterParamDTO{" +
                "username='" + userName + '\'' +
                ", password='" + passWord + '\'' +
                ", icon='" + icon + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UmsMemberRegisterParamDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getUsername() {
        return userName;
    }

    public UmsMemberRegisterParamDTO setUsername(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return passWord;
    }

    public UmsMemberRegisterParamDTO setPassword(String passWord) {
        this.passWord = passWord;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public UmsMemberRegisterParamDTO setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UmsMemberRegisterParamDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public UmsMemberRegisterParamDTO setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getNote() {
        return note;
    }

    public UmsMemberRegisterParamDTO setNote(String note) {
        this.note = note;
        return this;
    }
}

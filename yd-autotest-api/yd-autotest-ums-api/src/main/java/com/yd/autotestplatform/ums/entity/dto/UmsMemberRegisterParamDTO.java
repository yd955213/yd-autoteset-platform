package com.yd.autotestplatform.ums.entity.dto;
/**
 * <p>
 *  后台用户表
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-21 12:07
 * @Email: 664720125@qq.com
 */

public class UmsMemberRegisterParamDTO {

    private String username;
    private String password;
    private String icon;
    private String email;
    private String nickName;
    private String note;

    @Override
    public String toString() {
        return "UmsMemberRegisterParamDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", icon='" + icon + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public UmsMemberRegisterParamDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UmsMemberRegisterParamDTO setPassword(String password) {
        this.password = password;
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

package com.yd.autotestplatform.ums.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author yangdang
 * @since 2021-06-21
 */
public class UmsMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ums_id", type = IdType.AUTO)
    private Long umsId;

    private String username;

    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 备注信息
     */
    private String note;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_Create", fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_Modified", fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    /**
     * 最后登录时间
     */
    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUmsId() {
        return umsId;
    }

    public UmsMember setUmsId(Long umsId) {
        this.umsId = umsId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UmsMember setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UmsMember setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public UmsMember setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UmsMember setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public UmsMember setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getNote() {
        return note;
    }

    public UmsMember setNote(String note) {
        this.note = note;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public UmsMember setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public UmsMember setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public UmsMember setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UmsMember setStatus(Integer status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "UmsMember{" +
                "umsId=" + umsId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", icon='" + icon + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", note='" + note + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", loginTime=" + loginTime +
                ", status=" + status +
                '}';
    }
}

package com.yd.autotestplatform.service.ums.entity;

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


    public Long getUmsId() {
        return umsId;
    }

    public void setUmsId(Long umsId) {
        this.umsId = umsId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UmsMember{" +
        "umsId=" + umsId +
        ", username=" + username +
        ", password=" + password +
        ", icon=" + icon +
        ", email=" + email +
        ", nickName=" + nickName +
        ", note=" + note +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        ", loginTime=" + loginTime +
        ", status=" + status +
        "}";
    }
}

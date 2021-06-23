package com.yd.autotestplatform.ums.entity.response;

import com.yd.autotestplatform.ums.entity.UmsMember;

/**
 * <p>
 *
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-23 15:05
 * @Email: 664720125@qq.com
 */
public class UmsMemberLoginResponseParam {
    String token;
    UmsMember umsMember;

    public String getToken() {
        return token;
    }

    public UmsMemberLoginResponseParam setToken(String token) {
        this.token = token;
        return this;
    }

    public UmsMember getUmsMember() {
        return umsMember;
    }

    public UmsMemberLoginResponseParam setUmsMember(UmsMember umsMember) {
        this.umsMember = umsMember;
        return this;
    }

    @Override
    public String toString() {
        return "UmsMemberLoginResponseParam{" +
                "token='" + token + '\'' +
                ", umsMember=" + umsMember +
                '}';
    }
}

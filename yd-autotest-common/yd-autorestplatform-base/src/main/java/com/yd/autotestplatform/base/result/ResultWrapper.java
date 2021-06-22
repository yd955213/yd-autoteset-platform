package com.yd.autotestplatform.base.result;

import com.yd.autotestplatform.base.enums.StateCodeEnum;
import lombok.Builder;

import java.io.Serializable;

/**
 * <p>
 *  统一返回值
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-22 9:15
 * @Email: 664720125@qq.com
 */
@Builder
public class ResultWrapper<T> implements Serializable {
    /**
     * 状态码
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回数据详细信息
     */
    private T data;

    /**
     * 返回访问成功的包装
     * @return
     */
    public static ResultWrapper.ResultWrapperBuilder getSuccessBuilder(){
        return ResultWrapper.builder()
                .code(StateCodeEnum.SUCCESS.getCode())
                .msg(StateCodeEnum.SUCCESS.getMsg());
    }

    /**
     * 返回访问失败的包装
     * @return
     */
    public static ResultWrapper.ResultWrapperBuilder getFailBuilder(){
        return ResultWrapper.builder()
                .code(StateCodeEnum.FAIL.getCode())
                .msg(StateCodeEnum.FAIL.getMsg());
    }

    public int getCode() {
        return code;
    }

    public ResultWrapper<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultWrapper<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultWrapper<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ResultWrapper{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public ResultWrapper(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}

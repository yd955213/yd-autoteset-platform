package com.yd.autotestplatform.base.enums;

/**
 * <p>
 *  统一回复状态码：
 *  1001-1199: 用户业务的。
 *  3001-3199: 参数格式异常
 *  5001-5299: 后台服务处理异常
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-22 9:08
 * @Email: 664720125@qq.com
 */
public enum StateCodeEnum {
    /**
     * 用户名密码不正确
     */
    PASSWORD_ERROR(1001,"用户名密码不正确"),

    /**
     * 用户不存在
     */
    USER_EMPTY(1002,"用户不存在"),
    /**
     * 用户已存在
     */
    USER_EXISTS(1003,"用户已存在"),

    /**
     * 参数格式异常
     */
    ABNORMAL_PARAMETER_FORMAT(3001, "参数格式异常"),

    /**
     * ArithmeticException
     */
    ARITHMETIC_EXCEPTION(4001,"后台参数计算错误"),

    /**
     * 请求失败
     */
    FAIL(500,"请求失败"),

    /**
     * 请求成功
     */
    SUCCESS(200,"请求成功");

    private int code;
    private String msg;

    StateCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

//    public StateCodeEnum setCode(int code) {
//        this.code = code;
//        return this;
//    }

    public String getMsg() {
        return msg;
    }

//    public StateCodeEnum setMsg(String msg) {
//        this.msg = msg;
//        return this;
//    }
}

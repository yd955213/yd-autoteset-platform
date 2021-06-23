package com.yd.autotestplatform.base.custumExceptions;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * <p>
 *  自定义登录异常类
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-22 14:57
 * @Email: 664720125@qq.com
 */
public class LogicException extends SQLIntegrityConstraintViolationException {
    public LogicException(String message) {
        super(message);
    }

    public LogicException() {
        super();
    }
}

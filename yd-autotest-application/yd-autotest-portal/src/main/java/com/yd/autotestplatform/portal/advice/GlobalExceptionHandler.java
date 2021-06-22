package com.yd.autotestplatform.portal.advice;

import com.yd.autotestplatform.base.custumExceptions.LogicException;
import com.yd.autotestplatform.base.custumExceptions.TokenException;
import com.yd.autotestplatform.base.enums.StateCodeEnum;
import com.yd.autotestplatform.base.result.ResultWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * <p>
 *  全局异常处理类
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-22 14:33
 * @Email: 664720125@qq.com
 */
public class GlobalExceptionHandler {
    /**
     * 算术异常处理
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    public ResultWrapper arithmeticException(){

        return ResultWrapper.getFailBuilder()
                .code(StateCodeEnum.ARITHMETIC_EXCEPTION.getCode())
                .msg(StateCodeEnum.ARITHMETIC_EXCEPTION.getMsg()).build();
    }

    @ExceptionHandler(LogicException.class)
    public ResultWrapper userExistException(Exception e){
        System.out.println(e.getMessage());
        return ResultWrapper.getFailBuilder()
                .code(StateCodeEnum.USER_EXISTS.getCode())
                .msg(StateCodeEnum.USER_EXISTS.getMsg()).build();
    }

    @ExceptionHandler(TokenException.class)
    public ResultWrapper tokenException(){

        return ResultWrapper.getFailBuilder()
                .code(StateCodeEnum.FAIL.getCode())
                .msg(StateCodeEnum.FAIL.getMsg()).build();
    }
}

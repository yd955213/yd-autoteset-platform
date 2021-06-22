package com.yd.autotestplatform.portal.advice;

import com.yd.autotestplatform.base.enums.StateCodeEnum;
import com.yd.autotestplatform.base.result.ResultWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * <p>
 * 处理接口参数无效的类
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-22 11:29
 * @Email: 664720125@qq.com
 */
@ControllerAdvice
public class ValidateHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println(request);
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fieldError : ex.getFieldErrors()) {
            String defaultMessage = fieldError.getDefaultMessage();
            stringBuilder.append(defaultMessage + " ");
///            // 获取到一个错误后就退出循环
///            break;
        }
        return new ResponseEntity(ResultWrapper.getFailBuilder()
                .data(stringBuilder.toString())
                .code(StateCodeEnum.ABNORMAL_PARAMETER_FORMAT.getCode()).build(), HttpStatus.OK);
    }
}

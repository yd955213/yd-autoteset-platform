package com.yd.autotestplatform.portal.Interceptors;

import com.yd.autotestplatform.base.annotation.TokenCheck;
import com.yd.autotestplatform.base.custumExceptions.TokenException;
import com.yd.autotestplatform.util.JwtToken;
import org.springframework.util.ObjectUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * <p>
 *  权限拦截器，
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact: @TokenCheck
 * @date: 2021-06-23 14:24
 * @Email: 664720125@qq.com
 */
public class AuthInterceptor implements HandlerInterceptor {
    public String getToken() {
        return token;
    }

    private String token;
    /**
     * 预处理
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("**************************** AuthInterceptor ****************************");
        String token = request.getHeader("token");
        // 判断token 是否为空
        if(ObjectUtils.isEmpty(token)){
            throw new TokenException("token为空");
        }
        // 获取请求对应的controller层的方法名
        Method method = ((HandlerMethod)handler).getMethod();
        // 判断该方法是否有@TokenChech注解
        if (method.isAnnotationPresent(TokenCheck.class)){
            TokenCheck annotation = method.getAnnotation(TokenCheck.class);
            if (annotation.required()){
                try {
                    token = JwtToken.parseToken(token);
                    return true;
                }catch (Exception e){
                    throw new TokenException("token无效");
                }
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

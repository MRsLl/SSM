package com.atguigu.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstHandlerInterceptor implements HandlerInterceptor {
    //在目标方法之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstHandlerInterceptor preHandle()");
//        int i = 12/0;
        return true;
    }
    //在目标方法之后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("FirstHandlerInterceptor postHandle()");
//        int i = 12/0;
    }
    //在页面渲染完成之后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("FirstHandlerInterceptor afterCompletion()");
    }
}

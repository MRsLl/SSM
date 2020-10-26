package com.atguigu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class LogUtils {


    /**
     * 记录运算，以及运算参数
     *
     */
    public static void logBefore(JoinPoint joinPoint) {
        System.out.println("前置通知 logBefore() 方法名为：" + joinPoint.getSignature().getName() + ",参数值为" + Arrays.asList(joinPoint.getArgs()));
    }

    public static void logAfter(JoinPoint joinPoint) {
        System.out.println("后置通知 logAfter() 方法名为：" + joinPoint.getSignature().getName() + ",参数值为" + Arrays.asList(joinPoint.getArgs()));
    }


    /**
     * 记录运算，以及结果
     */

    public static void logAfterReturning(JoinPoint joinPoint,Object result) {
        System.out.println("返回通知 logAfterReturning()方法名为："  + joinPoint.getSignature().getName() + ",返回值为：" + result);
    }

    /**
     * 记录哪个功能、以及出了哪些异常
     */

    public static void logAfterThrowing(JoinPoint joinPoint,Exception e){
        System.out.println("异常通知 logAfterThrowing() 方法名为："  + joinPoint.getSignature().getName() + ",异常是：" + e);
    }


}

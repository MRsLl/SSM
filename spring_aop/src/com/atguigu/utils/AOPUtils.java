package com.atguigu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Aspect
public class AOPUtils {

    @Pointcut(value = "execution(public int com.atguigu.pojo.Calculator.*(..))")
    public void pointCut() {

    }

    /**
     * 记录运算，以及运算参数
     *
     */
    @Before(value = "pointCut()")
    public static void logBefore(JoinPoint joinPoint) {
        System.out.println("AOP 前置通知 logBefore() 方法名为：" + joinPoint.getSignature().getName() + ",参数值为" + Arrays.asList(joinPoint.getArgs()));
    }
    @After(value = "execution(public int com.atguigu.pojo.Calculator.*(..))")
    public static void logAfter(JoinPoint joinPoint) {
        System.out.println("AOP 后置通知 logAfter() 方法名为：" + joinPoint.getSignature().getName() + ",参数值为" + Arrays.asList(joinPoint.getArgs()));
    }


    /**
     * 记录运算，以及结果
     */
    @AfterReturning(value = "execution(public int com.atguigu.pojo.Calculator.*(..))" , returning = "result")
    public static void logAfterReturning(JoinPoint joinPoint,Object result) {
        System.out.println("AOP 返回通知 logAfterReturning()方法名为："  + joinPoint.getSignature().getName() + ",返回值为：" + result);
    }

    /**
     * 记录哪个功能、以及出了哪些异常
     */
    @AfterThrowing(value = "execution(public int com.atguigu.pojo.Calculator.*(..))" , throwing = "e")
    public static void logAfterThrowing(JoinPoint joinPoint,Exception e){
        System.out.println("AOP 异常通知 logAfterThrowing() 方法名为："  + joinPoint.getSignature().getName() + ",异常是：" + e);
    }

/*    @Around(value = "pointCut()")
    public static Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        try {
            try {
                System.out.println("环绕前置通知");
                result = proceedingJoinPoint.proceed();
            } finally {
                System.out.println("环绕后置通知");
            }
            System.out.println("环绕返回通知");
        } catch (Throwable throwable) {
            System.out.println("环绕异常通知");
            throwable.printStackTrace();
            throw throwable;
        }
        return result;

    }*/


}

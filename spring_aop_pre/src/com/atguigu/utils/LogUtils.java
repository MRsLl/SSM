package com.atguigu.utils;

import java.util.Arrays;

public class LogUtils {
    /**
     * 记录运算，以及运算参数
     *
     * @param method
     * @param args
     */
    public static void logBefore(String method, Object... args) {
        System.out.println(" 当前操作是：" + method + " ， 运算数是： " + Arrays.asList(args));
    }

    /**
     * 记录运算，以及结果
     */
    public static void logAfterReturning(String method, Object result) {
        System.out.println(" 当前操作是：" + method + " ， 结果是： " + result);
    }

    /**
     * 记录哪个功能、以及出了哪些异常
     */
    public static void logAfterThrowing(String method,Exception e){
        System.out.println(" 当前操作是：" + method + " ， 出现了异常是： " + e);
    }


}

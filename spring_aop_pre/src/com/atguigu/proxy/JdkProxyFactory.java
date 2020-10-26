package com.atguigu.proxy;

import com.atguigu.pojo.Caculate;
import com.atguigu.pojo.Caculator;
import com.atguigu.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory {

    public static Object create(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        try {
                            LogUtils.logBefore(method.getName(),args);
                            result = method.invoke(target, args);
                            LogUtils.logAfterReturning(method.getName(),result);
                        } catch (Exception e) {
                            LogUtils.logAfterThrowing(method.getName(),e);
                            throw new RuntimeException();
                        }
                        return result;
                    }
                }
        );
    }

    public static void main(String[] args) {
        Caculate caculate = new Caculator();
        Caculate proxy = (Caculate) JdkProxyFactory.create(caculate);
        int div = proxy.div(100, 0);
        System.out.println(div);
    }

}

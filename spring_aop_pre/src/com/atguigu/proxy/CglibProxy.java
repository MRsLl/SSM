package com.atguigu.proxy;

import com.atguigu.pojo.Caculator;
import com.atguigu.utils.LogUtils;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {

    public static Object createCglibProxy(Object target) {

        // cglib代理技术是通过继承目标对象的字节码对象来产生一个代理对象
        // 代理对象是目标对象的子类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置增强操作
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * MethodInterceptor相当于jdk动态代理的InvocationHandler接口
             * @param proxy     代理对象实例
             * @param method    代理对象调用的方法反射对象
             * @param args      传递的参数
             * @param methodProxy   方法反射对象的代理对象实例
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                try {
                    LogUtils.logBefore(method.getName(),args);
                    result = method.invoke(target, args);
                    LogUtils.logAfterReturning(method.getName(),result);
                } catch (Exception e) {
                    LogUtils.logAfterThrowing(method.getName(),e);
                }
                return result;
            }
        });

        //创建代理对象返回
        return enhancer.create();
    }

    public static void main(String[] args) {
        Caculator caculator = new Caculator();
        Caculator cglibProxy = (Caculator) CglibProxy.createCglibProxy(caculator);

        int add = cglibProxy.add(100, 100);
        System.out.println(" add 操作，返回值是 => " + add);

    }
}

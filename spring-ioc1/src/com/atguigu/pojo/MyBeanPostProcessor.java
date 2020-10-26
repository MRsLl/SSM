package com.atguigu.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" postProcessBeforeInitialization 初始化之前 id => " + beanName + " , 对象是 => " + bean);
        return bean;
    }

    /**
     * postProcessAfterInitialization() 初始化操作之后执行
     * @param bean      正在(创建|初始化)的对象
     * @param beanName  对象的唯一标识
     * @return  正在初始化 ( 创建 ) 的对象
     * @throws BeansException
     */

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" postProcessAfterInitialization 初始化之后 id => " + beanName + " , 对象是 => " + bean);
        if (beanName.equals("p22")){
            Person person = (Person)bean;
            person.setCar(new Car("保时捷911"));
        }
        return bean;
    }
}

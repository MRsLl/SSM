package com.atguigu.test;

import com.atguigu.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringELTest {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person springel = (Person) applicationContext.getBean("springel");
        System.out.println(springel);
    }
}

package com.atguigu.test;

import com.atguigu.pojo.Car;
import com.atguigu.pojo.Person;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Map;

public class SpringTest {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/applicationContext.xml");

        Person p1 = (Person) applicationContext.getBean("p1");
        System.out.println(p1);

        Person p2 = (Person) applicationContext.getBean("p1");
        System.out.println(p2);

        Person p3 = (Person) applicationContext.getBean("p1");
        System.out.println(p3);
    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p1 = applicationContext.getBean(Person.class);
        System.out.println(p1);
    }

    @Test
    public void test3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p2");
        System.out.println(person);
    }

    @Test
    public void test4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p4");
        System.out.println(person);
    }

    @Test
    public void test5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p5");
        System.out.println(person);
    }

    @Test
    public void test6() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p6");
        System.out.println(person);
    }

    @Test
    public void test7() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p7");
        System.out.println(person);
        System.out.println(person.getPhone());
    }

    @Test
    public void test8() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p8");
        System.out.println(person);
    }

    @Test
    public void test9() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p9");
        System.out.println(person);

        Car car2 = (Car) applicationContext.getBean("car2");
        System.out.println(car2);
    }

    @Test
    public void test10() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p10");
        System.out.println(person);
    }

    @Test
    public void test11() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p11");
        System.out.println(person);
    }

    @Test
    public void test12() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p12");
        System.out.println(person);
    }

    @Test
    public void test13() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p13");
        System.out.println(person);

        Map map01 = (Map) applicationContext.getBean("map01");
        System.out.println(map01);
    }

    @Test
    public void test14() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p14");
        System.out.println(person);
    }

    @Test
    public void test15() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p15");
        System.out.println(person);
    }

    @Test
    public void test16() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p16");
        System.out.println(person);
    }

    @Test
    public void test17() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p17");
        System.out.println(person);
    }

    @Test
    public void test18() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p18");
        System.out.println(person);

        Person parent = (Person) applicationContext.getBean("parent");
        System.out.println(parent);
    }
}

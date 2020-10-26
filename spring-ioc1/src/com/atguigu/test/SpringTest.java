package com.atguigu.test;

import com.atguigu.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class SpringTest {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person p1 = (Person) applicationContext.getBean("p20");
        System.out.println(p1);
        Person p2 = (Person) applicationContext.getBean("p20");
        System.out.println(p1);
        Person p3 = (Person) applicationContext.getBean("p20");
        System.out.println(p1);

        Person p4 = (Person) applicationContext.getBean("p21");
        System.out.println(p4);
        Person p5 = (Person) applicationContext.getBean("p21");
        System.out.println(p5);
        Person p6 = (Person) applicationContext.getBean("p21");
        System.out.println(p6);
    }

    @Test
    public void test3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person MrsLiu = (Person) applicationContext.getBean("p30");
        System.out.println(MrsLiu);
    }

    @Test
    public void test4() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(applicationContext.getBean("p22"));

        applicationContext.close();
    }

    @Test
    public void testDataSource() throws SQLException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

}

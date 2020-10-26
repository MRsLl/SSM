package com.atguigu.test;

import com.atguigu.pojo.Calculate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//locations是位置，表示Spring容器配置文件的路径
@ContextConfiguration(locations = "classpath:applicationContext.xml")
// 表示使用Spring扩展的junit测试运行器
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringAopTest {
    @Autowired
    Calculate calculate;

    @Test
    public void test1() {
        int add = calculate.add(10, 100);
        System.out.println(add);

//        int div = calculate.div(100, 0);
    }

}

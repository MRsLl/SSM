package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 配置Junit扩展后的测试中Spring容器需要的配置文件
@ContextConfiguration(locations = "classpath:applicationContext.xml")
// RunWith 表示使用Spring扩展好的测试类
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {
    @Autowired
    BookService bookService;
    @Autowired
    BookDao bookDao;

    @Test
    public void test() {
        System.out.println(bookDao);
        System.out.println("===========================");
        System.out.println(bookService);
    }
}

package com.atguigu.test;

import com.atguigu.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionTest {
    @Autowired
    TransactionService transactionService;
    @Test
    public void test() {
        transactionService.multiUpdate();
    }

    @Test
    public void test1() {
        transactionService.multiTransaction();
    }

}

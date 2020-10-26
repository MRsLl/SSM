package com.atguigu.service;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {
    @Autowired
    BookDao bookDao;
    @Autowired
    UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void multiUpdate() {
        bookDao.updateBook();
        int i = 12/0;
        userDao.updateUser();
    }

    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;
    @Transactional(propagation = Propagation.REQUIRED)
    public void multiTransaction() {
        userService.updateUser();

        bookService.updateBook();
    }
}

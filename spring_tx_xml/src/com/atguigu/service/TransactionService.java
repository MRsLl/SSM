package com.atguigu.service;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    BookDao bookDao;
    @Autowired
    UserDao userDao;

    public void multiUpdate() {
        bookDao.updateBook();
        int i = 12/0;
        userDao.updateUser();
    }

    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    public void multiTransaction() {
        bookService.updateBook();

        int i = 12/0;

        userService.updateUser();
    }
}

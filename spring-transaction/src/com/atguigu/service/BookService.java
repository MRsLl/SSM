package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateBook() {
        int i = 12/0;
        bookDao.updateBook();
    }
}

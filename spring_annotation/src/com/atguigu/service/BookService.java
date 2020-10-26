package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired(required = false)
    @Qualifier("bookDao")
    BookDao bookDaoExt;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDaoExt +
                '}';
    }
    @Autowired(required = false)
    public void abc(@Qualifier("bookDaoExt") BookDao bookDao) {
        System.out.println("abc method called !!! ==>>" + bookDao);
    }
}

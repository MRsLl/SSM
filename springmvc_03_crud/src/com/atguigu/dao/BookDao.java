package com.atguigu.dao;

import com.atguigu.pojo.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    int saveBook(Book book);

    int updateBook(Book book);

    int deleteBookById(Integer id);

    Book queryBookById(Integer id);

    List<Book> queryBooks();
}

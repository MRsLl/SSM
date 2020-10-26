package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

@ContextConfiguration(locations = "classpath:springmvc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest {
    @Autowired
    BookService bookService;

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"西游记","吴承恩",new BigDecimal(100),50,10));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"水浒传","施耐庵",new BigDecimal(1000),500,10));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(10);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> bookList = bookService.queryBooks();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
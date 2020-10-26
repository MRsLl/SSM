package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

@ContextConfiguration(locations = "classpath:springmvc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookDaoTest {

    @Autowired
    BookDao bookDao;

    @Test
    public void saveBook() {
        bookDao.saveBook(new Book(null,"西游记","吴承恩",new BigDecimal(100),50,10));
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"水浒传","施耐庵",new BigDecimal(100),100,10));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(1);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> bookList = bookDao.queryBooks();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
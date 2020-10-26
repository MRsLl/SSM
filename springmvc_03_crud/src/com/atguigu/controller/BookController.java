package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String add(Book book) {
        bookService.addBook(book);
        return "redirect:/book";
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return "redirect:/book";
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.PUT)
    public String update(Book book) {
        bookService.updateBook(book);
        return "redirect:/book";
    }

    @RequestMapping(value = "/book",method = RequestMethod.GET)
    public String queryAll(Map<String,Object> map) {
        //调用 bookService 的
        List<Book> bookList = bookService.queryBooks();

        map.put("books",bookList);
        return "bookList";
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.GET)
    public String queryBookById(@PathVariable Integer id,Map<String,Object> map) {
        Book book = bookService.queryBookById(id);

        map.put("book",book);
        return "bookEdit";
    }
}

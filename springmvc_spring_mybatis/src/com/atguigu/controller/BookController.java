package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/saveBook")
    public String saveBook() {
        bookService.saveBook(new Book(null,"冰火两重天","唐家三少",new BigDecimal(50),500,10));
        return "/index.jsp";
    }
}

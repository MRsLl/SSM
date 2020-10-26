package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/book")
@Controller
public class BookController {

    @RequestMapping(value = "/{id}/{abc}")
    public String queryBookById(@PathVariable Integer id,
                                @PathVariable String abc) {
        System.out.println("根据id" + id + "查询图书" + abc);
        return "redirect:/index.jsp";
    }

    @RequestMapping
    public String queryBooks() {
        System.out.println("查询所有图书");
        return "redirect:/index.jsp";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add() {
        System.out.println("添加图书");
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/1" ,method = RequestMethod.PUT)
    public String update() {
        System.out.println("根据id 修改图书");
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/1",method = RequestMethod.DELETE)
    public String delete() {
        System.out.println("根据id 删除图书");
        return "redirect:/index.jsp";
    }
}

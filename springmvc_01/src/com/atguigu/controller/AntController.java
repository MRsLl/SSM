package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AntController {
    //? 表示任意一个字符
    @RequestMapping(value = "fu?")
    public String fun1() {
        System.out.println("fun1() fu?...");
        return "ok";
    }

    //表示任意个字符
    @RequestMapping(value = "/fu*")
    public String fun2() {
        System.out.println("fun2() fu*...");
        return "ok";
    }

    //? 匹配一个字符的目录
    @RequestMapping(value = "/?/fun")
    public String fun3() {
        System.out.println("fun3() /?/fun...");
        return "ok";
    }

    //* 匹配多个字符的一层目录
    @RequestMapping(value = "/*/fun")
    public String fun4() {
        System.out.println("fun4() /*/fun...");
        return "ok";
    }

    //** 匹配多层目录
    @RequestMapping(value = "/**/fun")
    public String fun5() {
        System.out.println("fun5() /**/fun...");
        return "ok";
    }
}

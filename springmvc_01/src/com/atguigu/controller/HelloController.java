package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        /**
         * / 斜杠在服务器上表示地址为：http://ip:port/工程路径/ 映射到代码的web目录 <br/>
         *  返回值是跳转的路径 ， 默认是请求转发
         */
        System.out.println("SpringMvc,Hello...");
        return "ok";
    }
}

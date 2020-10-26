package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class helloController {
    @RequestMapping(value = "/hello")
    public String hello(Map<String,Object> map) {
        System.out.println("hello");
        map.put("k1","v1");
        map.put("k2","v2");

        int i = 12/0;
        return "ok";
    }

    @RequestMapping(value = "/hellotwo")
    public String hellotwo() {
        System.out.println("hellotwo");
        return "ok";
    }
}

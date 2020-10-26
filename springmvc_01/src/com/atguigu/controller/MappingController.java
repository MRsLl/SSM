package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/map")
@Controller
public class MappingController {

    @RequestMapping(path = {"/map1","/bbj","/xxx"})
    public String map1() {
        System.out.println("这是 map1 方法");
        return "ok";
    }

    @RequestMapping(path = "/map2",params = "username!=abc")
    public String map2() {
        System.out.println("这是 map2 方法");
        return "ok";
    }

    @RequestMapping(path = "/map3",headers = "User-Agent")
    public String map3() {
        System.out.println("这是 map3 方法");
        return "ok";
    }

    @RequestMapping(path = "/map4",method = RequestMethod.POST)
    public String map4() {
        System.out.println("这是 map4 方法");
        return "ok";
    }

}

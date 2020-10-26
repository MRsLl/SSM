package com.atguigu.controller;

import com.atguigu.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@RequestMapping(value = "/param")
@Controller
public class ParamController {
    @RequestMapping(path = "/param1")
    public String param1(HttpServletRequest httpServletRequest,
                         HttpSession httpSession,
                         HttpServletResponse response){
        System.out.println("请求的url 地址" + httpServletRequest.getRequestURI());
        System.out.println("请求的地址" + httpServletRequest.getRequestURL());
        System.out.println("请求的工程路径" + httpServletRequest.getContextPath());
        System.out.println(httpSession);
        return "ok";
    }

    @RequestMapping(value = "/param2")
    public String param2(String username,String password){
        System.out.println(username);
        System.out.println(password);
        return "ok";
    }

    @RequestMapping(value = "/param3")
    public String param3(String[] hobby){
        System.out.println(Arrays.asList(hobby));
        return "ok";
    }

    @RequestMapping(value = "/param4")
    public String param4(@RequestParam(name = "user" ,defaultValue = "lisisi",
            required = false) String username){
        System.out.println(username);
        return "ok";
    }

    @RequestMapping(value = "/param5")
    public String param5(
            @RequestHeader(name = "User-Agent") String userAgent,
            @RequestHeader(name = "Accept-Encoding") String acceptEncoding){
        System.out.println(userAgent);
        System.out.println(acceptEncoding);

        return "ok";
    }

    @RequestMapping(value = "/param6")
    public String param6(@CookieValue(name = "JSESSIONID") String jsessionId) {
        System.out.println(jsessionId);

        return "ok";
    }

    @RequestMapping(value = "/param7")
    public String param7(Person person) {
        System.out.println(person);
        return "ok";
    }
}

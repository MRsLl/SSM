package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@SessionAttributes(types = Integer.class)
@Controller
public class ScopeController {

    @RequestMapping(value = "/sessionAttributes")
    public String sessionAttributes(Map<String,Object> map){
        map.put("key1","value1");
        map.put("key2",new Integer(100));

        return "scope_out";
    }

    @RequestMapping(value = "/requestScope")
    public String requestScope(HttpServletRequest request) {
        System.out.println("requestScope()");
        request.setAttribute("requestKey1","requestValue1");
        request.setAttribute("requestKey2","requestValue2");

        return "scope_out";
    }

    @RequestMapping(value = "/sessionScope")
    public String sessionScope(HttpSession session) {
        System.out.println("sessionScope()");
        session.setAttribute("seKey1","seValue1");
        session.setAttribute("seKey2","seValue2");

        return "scope_out";
    }

    @RequestMapping(value = "/applicationScope")
    public String applicationScope(HttpSession session) {
        System.out.println("applicationScope()");
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("scKey1","scValue1");
        servletContext.setAttribute("scKey2","scValue2");

        return "scope_out";
    }

    @RequestMapping(value = "/mapToRequest")
    public String mapToRequest(Map<String,Object> map) {
        System.out.println("mapToRequest()");
        map.put("mapKey1","mapValue1");
        map.put("mapKey2","mapValue2");

        return "scope_out";
    }

    @RequestMapping(value = "/modelAndViewToRequest")
    public ModelAndView modelAndViewToRequest() {
        ModelAndView modelAndView = new ModelAndView("scope_out");

        modelAndView.addObject("mavKey1","mavValue1");
        modelAndView.addObject("mavKey2","mavValue2");

        return modelAndView;
    }
}

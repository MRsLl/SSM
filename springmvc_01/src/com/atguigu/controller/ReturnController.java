package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnController {

    @RequestMapping(path = "/return2")
    public String return2() {
        System.out.println("return2(): 显式转发");
        return "forward:/pages/ok.jsp";
    }

    @RequestMapping(path = "/return3")
    public String return3() {
        System.out.println("return3(): 显式重定向");
        return "redirect:/pages/ok.jsp";
    }

    @RequestMapping(value = "/modelAndView1")
    public ModelAndView modelAndView1() {
        ModelAndView modelAndView = new ModelAndView("ok");
        System.out.println("modelAndView1() ");
        return modelAndView;
    }

    @RequestMapping(value = "/modelAndView2")
    public ModelAndView modelAndView2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/pages/ok.jsp");
        System.out.println("modelAndView2() ");
        return modelAndView;
    }
}

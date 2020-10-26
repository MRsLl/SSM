package com.atguigu.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class LastController {
    @RequestMapping(value = "/upload")
    public String upload(
            @RequestParam("username") String username,
            @RequestParam("photo") MultipartFile photo
            ) {
        System.out.println("用户名=>" + username);

        try {
            //上传的文件名
           String fileName = photo.getOriginalFilename();
            photo.transferTo(new File("d:/" + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/index.jsp";
    }

    @RequestMapping(path = "/download")
    public ResponseEntity<byte[]> download(HttpSession session) throws IOException {
        String fileName = "commons-io-1.4.jar";

        ServletContext servletContext = session.getServletContext();

        //在响应头中要设置两个内容，分别是返回的数据类型mime，还要让浏览器知道收到的数据用于下载
        MultiValueMap headers = new HttpHeaders();
        //获取下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + fileName);
        //设置返回的数据类型
        headers.add("Content-Type",mimeType);
        //设置收到的数据如何处理
        headers.add("Content-Disposition","attachment;filename=" + fileName);
        //读取指定路径的文件，以流形式返回
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + fileName);
        //toByteArray() 读取输入流中所有数据，转换为byte[] 数组返回
        byte[] body = IOUtils.toByteArray(resourceAsStream);


        return null;
    }
}

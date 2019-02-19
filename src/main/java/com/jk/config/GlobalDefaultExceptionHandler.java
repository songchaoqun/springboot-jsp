package com.jk.config;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public void index(HttpServletRequest req, Exception e){
        String username = (String)req.getAttribute("username");
        System.out.println("项目出异常了"+username);
    }
}

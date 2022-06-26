package com.my.project.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String catcher(Exception e, Model m){
        m.addAttribute("e",e);
        return "error";
    }
//
//
//    @RequestMapping("/ex")
//    public void error1() throws Exception {
//        throw new Exception("에외가 발생함.");
//    }
//
//    @RequestMapping("/ex2")
//    public String error2() throws Exception {
//        throw new Exception("에외가 발생함.");
//    }
}

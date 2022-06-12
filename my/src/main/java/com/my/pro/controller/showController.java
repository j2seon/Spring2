package com.my.pro.controller;

import com.my.pro.service.ProductServie;
import com.my.pro.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/show")
public class showController {

    @Autowired
    ShowService showService;


    // 상품리스트 보여주기
    @GetMapping("/list")
    public String menuList(HttpServletRequest request){

        HttpSession session = request.getSession(false);

        return "menuList";
    }

}

package com.my.pro.controller;

import com.my.pro.dto.ProductDto;
import com.my.pro.service.CateService;
import com.my.pro.service.ProductServie;
import com.my.pro.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/show")
public class showController {

    @Autowired
    ShowService showService;

    @Autowired
    CateService cateService;

    // 상품리스트 보여주기
    @GetMapping("/list")
    public String menuList(String cateCode, Integer tier, Model m, HttpServletRequest request){

        try {
            List<ProductDto> list = showService.list(cateCode,tier);
            m.addAttribute("list",list);



        } catch (Exception e) {
            e.printStackTrace();
        }


        return "menuList";

    }

}

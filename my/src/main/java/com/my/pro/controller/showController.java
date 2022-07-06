package com.my.pro.controller;

import com.my.pro.domain.CateDto;
import com.my.pro.domain.ProductDto;
import com.my.pro.service.CateService;
import com.my.pro.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String menuList(@RequestParam(value = "code", defaultValue = "100") String cateCode, @RequestParam(value = "t", required = false, defaultValue = "1") Integer tier, Model m, HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        try {
            List<CateDto> category = cateService.categoryList();
            List<ProductDto> list = showService.getList(tier, cateCode);
            m.addAttribute("list", list);
            m.addAttribute("category", category);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "menuList";

    }

    @GetMapping("/mypage")
    public String myPage() {
        return "myPage";
    }

    @GetMapping("/map")
    public String map() {
        return "test/map";
    }


    @GetMapping("/map1")
    public String map1() {
        return "test/map1";
    }
    @GetMapping("/map2")
    public String map2() {
        return "test/map2";
    }
    @GetMapping("/map3")
    public String map3() {
        return "test/map3";
    }
}


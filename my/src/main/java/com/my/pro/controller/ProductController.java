package com.my.pro.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.pro.dto.CateDto;
import com.my.pro.service.CateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private Logger logger= LoggerFactory.getLogger(ProductController.class);
    @Autowired
    CateService cateService;

    @GetMapping("/add")
    public String goodAdd(HttpSession session, Model m){
        //상품등록화면 보이게하기
        //추후 관리자만 등록할 수 있도록 바꾸기(세션이용하면 될듯)

        ObjectMapper objm = new ObjectMapper();

        try {
            //카테고리 페이지 누르면 카테고리의 값을 받아야하니까!
            List<CateDto> list = cateService.categoryList();
            String category = objm.writeValueAsString(list);
            logger.info("category"+category );
            m.addAttribute("category",category);
            return "productRegister";

        } catch (Exception e) {
            e.printStackTrace();
            return "main";
        }
    }

    @PostMapping("/add")
        public String goodAdd(Model m){
        return "";
    }


}

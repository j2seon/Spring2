package com.my.pro.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.pro.dto.CateDto;
import com.my.pro.dto.ProductDto;
import com.my.pro.service.CateService;
import com.my.pro.service.ProductServie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private Logger logger= LoggerFactory.getLogger(ProductController.class);
    @Autowired
    CateService cateService;

    @Autowired
    ProductServie productServie;

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
        public String goodAdd(ProductDto dto, Model m, RedirectAttributes rattr){
        try {
            int rowCnt=productServie.add(dto);

            if(rowCnt!=1)
                throw new Exception("ADD_Fail");

            rattr.addFlashAttribute("msg", "ADD_OK");
            //상품리스트로이동하도록 수정 >아직안만듬
            return "redirect:/board/list";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(dto);
            m.addAttribute("msg", "ADD_Fail");
            return "productRegister";
        }

    }


}

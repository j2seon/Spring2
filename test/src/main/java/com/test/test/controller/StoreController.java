package com.test.test.controller;

import com.test.test.domain.SearchCondition;
import com.test.test.domain.StoreDto;
import com.test.test.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService storeService;

//    //맞춤검색 리스트페이지
//    @RequestMapping(method = RequestMethod.GET, value = "/list")
//        public String list(@RequestParam(value="type",required = false) String type , @RequestParam(value="k",required = false) String keyword, Model model, HttpServletRequest request) throws Exception {
//            if(type==null && keyword==null){
//                List<StoreDto> list = storeService.AllStore();
//                model.addAttribute("list",list);
//            }else{
//                SearchCondition sc = new SearchCondition(type,keyword);
//                List<StoreDto> list = storeService.category(sc);
//                model.addAttribute("list",list);
//            }
//            String URL =request.getRequestURI();
//
//            return "breadStore";
//        }

    //상품상세페이지
    @RequestMapping(method = RequestMethod.GET, value ="/read" )
        public String storeRead(Integer id, Model model,HttpServletRequest request){
            StoreDto storeDto = storeService.getStore(id);
            String before_address = request.getHeader("referer");
            if(storeDto==null){
                return "redirect:/store/list";
            }
            model.addAttribute("storeDto",storeDto);
            model.addAttribute("before",before_address);
            return "store";
        }





}

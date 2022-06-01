package com.my.pro.controller;


import com.my.pro.dto.UserDto;
import com.my.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class registerController {

    @Autowired
    UserService userService;


    @GetMapping("/add")
    public String register(){
        //화면보여주기

        return "register";
    }
    
    @PostMapping("/add")
    public String save(UserDto dto, Model m){
        try {
            userService.register(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/"; //회원가입하면 홈화면으로 가게하자
    }

    @ResponseBody
    @PostMapping("/idCheck") //아이디 중복체크 유효성검사
    public int idCheck(String id)  {
        try {
            int result = userService.idCheck(id);

            return result==0? 0:1;

        } catch (Exception e) {
            return 1;
        }
    }
    
    


}

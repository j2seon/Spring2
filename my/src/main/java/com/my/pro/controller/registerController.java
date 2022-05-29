package com.my.pro.controller;


import com.my.pro.dao.UserDao;
import com.my.pro.dto.UserDto;
import com.my.pro.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class registerController {

    @Autowired
    Userservice userservice;

    @GetMapping("/add")
    public String register(){
        //화면보여주기

        return "registerForm";
    }
    
    @PostMapping("/add")
    public String save(UserDto dto, Model m){
        try {
            userservice.register(dto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index"; //회원가입하면 홈화면으로 가게하자
    }
    
    


}

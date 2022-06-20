package com.my.pro.controller;


import com.my.pro.domain.UserDto;
import com.my.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/register")
public class registerController {

    @Autowired
    UserService userService;


    @GetMapping("/add")
    public String register(HttpServletRequest request){
        //화면보여주기
        if(request.getSession(false)!=null){
            request.getSession(false).invalidate();
        }
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

//    @PostMapping("/modify")
//    public String userModify(UserDto dto, Model m, RedirectAttributes rattr){
//
//        try {
//            if(userService.login(dto)==null)
//                 throw new Exception();
//            userService.s
//            if(userService.userModify(dto)!=1)
//                throw new Exception();
//
//            rattr.addFlashAttribute("msg","modiOK");
//            return "redirect:/show/mypage";
//        } catch (Exception e) {
//            rattr.addFlashAttribute("msg","MODFail");
//            return "myPage";
//        }
//    }


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

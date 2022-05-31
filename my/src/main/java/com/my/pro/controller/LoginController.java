package com.my.pro.controller;

import com.my.pro.dto.UserDto;
import com.my.pro.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.http.HttpResponse;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    Userservice userservice;

    //1.로그인 화면으로 이동함.
    @GetMapping("/login")
    public String loginForm(){
        return "loginForm";
    }

    //2.로그인 화면에서 데이터를 전송
    @PostMapping("/login")                  //rememberId는 체크박스에 쿠키저장할건지 표시!!
    public String login(UserDto dto,String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response) throws Exception {

        UserDto userDto = userservice.login(dto); //유저로그인

        if(userDto==null){
            String msg = URLEncoder.encode("id, pw가 일치하지 않습니다.","UTF-8");
            return "redirect:/login/login?msg="+msg;
        }

            //일치해야 세션을 가져오는 걸로
        HttpSession session = request.getSession();
        session.setAttribute("id", dto.getId());

        //쿠키 생성희망하면 만들어주기
        if(rememberId){
            Cookie cookie = new Cookie("id",dto.getId());
            response.addCookie(cookie);
        }else{
            Cookie cookie = new Cookie("id",dto.getId());
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        toURL = toURL==null || toURL.equals("") ? "/" : toURL;

        return "redirect:"+toURL;
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 1. 세션을 종료
        session.invalidate();
        // 2. 홈으로 이동
        return "redirect:/";
    }
}



package com.my.pro.controller;

import com.my.pro.dto.UserDto;
import com.my.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    //1.로그인 화면으로 이동함.
    @GetMapping("/login")
    public String loginForm(){
        return "loginForm";
    }

    //2.로그인 화면에서 데이터를 전송
    @PostMapping("/login")                  //rememberId는 체크박스에 쿠키저장할건지 표시!!
    public String login(UserDto dto , String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response
    , RedirectAttributes rttr) {

        try {
            UserDto user=userService.login(dto);
            if(user==null){
               // String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
                rttr.addFlashAttribute("msg","id 또는 pwd가 일치하지 않습니다.");

                return "redirect:/login/login";

            }else{

                HttpSession session = request.getSession();
                session.setAttribute("id",user.getId());

                if(rememberId){
                    Cookie cookie = new Cookie("id",user.getId());
                    response.addCookie(cookie);
                }else{
                    Cookie cookie = new Cookie("id",user.getId());
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }

                toURL = toURL==null || toURL.equals("") ? "/" : toURL;
                return "redirect:"+toURL;

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 1. 세션을 종료
        session.invalidate();
        // 2. 홈으로 이동
        return "redirect:/";
    }
}



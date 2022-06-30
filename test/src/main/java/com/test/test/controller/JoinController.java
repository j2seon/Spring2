package com.test.test.controller;

import com.test.test.domain.JoinDto;
import com.test.test.domain.JoinDto2;
import com.test.test.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/join")
public class JoinController {

    @Autowired
    JoinService joinService;

    @GetMapping("/firstlist")
    public String list(JoinDto joinDto, Model m){
        List<JoinDto> joinList = joinService.getList1();
        m.addAttribute("joinlist", joinList);
        return "joinList1";
    }

    @GetMapping("/secondlist")
    public String list2(JoinDto2 JoinDto2, Model m){
        List<JoinDto2> joinList = joinService.getList2();
        m.addAttribute("joinlist", joinList);
        return "joinList";
    }




}

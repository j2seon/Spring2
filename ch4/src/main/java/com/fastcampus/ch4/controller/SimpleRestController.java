package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.domain.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController //RestController가 클래스에 붙게되면 ResponseBody가 자동으로 붙게된다.
public class SimpleRestController {
//    @GetMapping("/ajax")
//    public String ajax() {
//        return "ajax";
//    }



    @GetMapping("/test") //애는 보여줘야하는게 test라는 뷰라서 그냥 controller
    public String test() {
        return "test"; //보여줄 뷰이름.
    }


    @PostMapping("/send")
    //@ResponseBody
    public Person test(@RequestBody Person p) {
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p;
    }
}
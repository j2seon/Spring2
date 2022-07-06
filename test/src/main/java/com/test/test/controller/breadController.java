package com.test.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bread")
public class breadController {

    //빵 메인페이지
    @RequestMapping(method = RequestMethod.GET)
    public String breadMain(){
         return "main";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/map")
    public String breadmap() {
        return "map";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/api")
    public String breadApi() {
        return "api1";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/tour")
    public String breadTourApi() {
        return "api2";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/search")
    public String search() {
        return "search";
    }
}

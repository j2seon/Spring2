package com.test.test.controller;

import com.test.test.domain.StoreDto;
import com.test.test.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tour")
public class tourController {

    @Autowired
    StoreService storeService;

    @RequestMapping(method = RequestMethod.GET,value = "/region")
    public String breadmap() {
        return "map";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/region")
    public List<StoreDto> Storelist(String address, Model m) {
        List<StoreDto> list = storeService.regionStore(address);
        return list;
    }



}

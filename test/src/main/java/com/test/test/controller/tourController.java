package com.test.test.controller;

import com.test.test.domain.StoreDto;
import com.test.test.domain.TourDto;
import com.test.test.service.StoreService;
import com.test.test.service.TourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/tour")
public class tourController {

    @Autowired
    StoreService storeService;

    @Autowired
    TourService tourService;


    @RequestMapping(method = RequestMethod.GET,value = "/region")
    public String breadMap(String address,Model m)throws Exception {
        if(address==null){
            return "map";
        }
        int totalCnt = tourService.regionGetCount(address);
        m.addAttribute("totalCnt",totalCnt);

        List<TourDto> list = tourService.regionGetTour(address);
        m.addAttribute("list",list);
        return "map";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/map")
    public String breadTourApi(String no,Model m){
        TourDto tourDto = tourService.getRead(no);
        StoreDto start = storeService.getStore(tourDto.getStartPoint());
        m.addAttribute("start",start);
        StoreDto end = storeService.getStore(tourDto.getEndPoint());
        m.addAttribute("end",end);
        String way = tourDto.getWayPoint();


        return "api2";
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/tour")
//    public String list(@RequestBody StoreDto storeDto)throws Exception{
//
//
//    }









}

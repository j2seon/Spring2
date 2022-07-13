package com.test.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.test.domain.PageHandler;
import com.test.test.domain.SearchCondition;
import com.test.test.domain.StoreDto;
import com.test.test.domain.TourDto;
import com.test.test.service.StoreService;
import com.test.test.service.TourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/tour")
public class tourController {

    @Autowired
    StoreService storeService;

    @Autowired
    TourService tourService;

    //지도 클릭 > 지역별 리스트 출력 (페이징o)
    @RequestMapping(method = RequestMethod.GET,value = "/region")
    public String breadMap(String address, SearchCondition sc ,Model m)throws Exception {
        if(address==null){
            return "regionTour";
        }
        int totalCnt = tourService.regionGetCount(address);
        m.addAttribute("totalCnt",totalCnt);
        PageHandler pageHandler = new PageHandler(sc,totalCnt);
        m.addAttribute("ph",pageHandler);
        sc.setType(address);
        List<TourDto> list = tourService.regions(sc);
        m.addAttribute("list",list);
        Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
        m.addAttribute("startOfToday", startOfToday.toEpochMilli());
        return "regionTour";
    }

    //api이용 루트 출력
    @RequestMapping(method = RequestMethod.GET, value = "/map/{no}")
    public String breadTourApi(@PathVariable Integer no,Model m) throws JsonProcessingException {
        System.out.println(no);
        TourDto tourDto = tourService.getRead(no);
        StoreDto start = storeService.getStore(tourDto.getStartPoint()); //출발점 dto
        m.addAttribute("start",start);
        StoreDto end = storeService.getStore(tourDto.getEndPoint()); //도작점dto
        m.addAttribute("end",end);
        String way = tourDto.getWayPoint(); //경유지 dto
        String jsonArr = "[{\"id\":3},{\"id\":4}]"; //test로
        ObjectMapper objectMapper = new ObjectMapper();
        List<StoreDto> wayStore = objectMapper.readValue(jsonArr, new TypeReference<List<StoreDto>>() {});
        //더 좋은방법있을거같은데........
        for(int i=0; i<wayStore.size(); i++){
         StoreDto d = storeService.getStore(wayStore.get(i).getId());
            wayStore.set(i,d);
        }
        String wayJson = objectMapper.writeValueAsString(wayStore);
        m.addAttribute("wayJson",wayJson);
        m.addAttribute("wayStore",wayStore);
        m.addAttribute("way",way);
        return "tourApi";
    }

    //투어 등록 페이지 보여주기
    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register (){
        return "tourAdd";
    }

//    @RequestMapping(value = "register",method = RequestMethod.POST)
//    public String registerAdd(TourDto dto, HttpSession session,Model m){
////        String id = (String)session.getAttribute("id"); 작성자 값이 필요할거같음.
//
//
//    }







}

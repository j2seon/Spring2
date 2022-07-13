package com.test.test.service;

import com.test.test.domain.SearchCondition;
import com.test.test.domain.TourDto;

import java.util.List;

public interface TourService {

    List<TourDto> regions(SearchCondition sc); //지역별 리스트 페이징중
    int regionGetCount(String address); //지역별 출력 갯수
    List<TourDto> allTour(); //전체투어출력
    TourDto getRead(Integer no);//투어1개 읽기


    }

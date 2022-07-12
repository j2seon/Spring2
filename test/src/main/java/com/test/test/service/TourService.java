package com.test.test.service;

import com.test.test.domain.TourDto;

import java.util.List;

public interface TourService {

    List<TourDto> regionGetTour(String address); // 지역별 리스트 출력
    int regionGetCount(String address); //지역별 출력 갯수
    List<TourDto> allTour(); //전체투어출력
    TourDto getRead(String no);//투어1개 읽기


    }

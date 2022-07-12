package com.test.test.service;

import com.test.test.domain.SearchCondition;
import com.test.test.domain.StoreDto;

import java.util.List;

public interface StoreService {
    List<StoreDto> regionStore(String address); //시,도별 가게
    List<StoreDto>AllStore() throws Exception; //전체가게 출력 페이징 x
    StoreDto getStore(Integer id); //가게 1개 출력
    List<StoreDto> getList(SearchCondition sc);// 1page > 10개 출력 + 검색조건
    int getCount(SearchCondition sc); //가게 갯수(검색조건별 변경o)

    }

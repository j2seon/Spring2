package com.test.test.dao;

import com.test.test.domain.SearchCondition;
import com.test.test.domain.TourDto;

import java.util.List;

public interface TourDao {
    List<TourDto> regions(SearchCondition sc);
    int regionCount(String address);
    List<TourDto> selectAll();
    TourDto read(Integer no);
    int viewCount(Integer no);


    }

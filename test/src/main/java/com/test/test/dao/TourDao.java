package com.test.test.dao;

import com.test.test.domain.SearchCondition;
import com.test.test.domain.TourDto;

import java.util.List;

public interface TourDao {
    List<TourDto> region(String address);
    int regionCount(String address);
    List<TourDto> selectAll();

    List<TourDto> test(SearchCondition sc);
    TourDto read(String no);


    }

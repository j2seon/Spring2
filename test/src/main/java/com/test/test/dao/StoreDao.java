package com.test.test.dao;

import com.test.test.domain.SearchCondition;
import com.test.test.domain.StoreDto;

import java.util.List;

public interface StoreDao {
    List<StoreDto> selectAll() throws Exception;

    List<StoreDto> Region(String address);

//    List<StoreDto> searchStore1(SearchCondition sc);
//
//    List<StoreDto> searchStore2(SearchCondition sc);
    StoreDto selectOne(Integer id);

    List<StoreDto> selectResultpage(SearchCondition sc);

    }

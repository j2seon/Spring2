package com.test.test.dao;

import com.test.test.domain.SearchCondition;
import com.test.test.domain.StoreDto;

import java.util.List;

public interface StoreDao {
    List<StoreDto> selectAll() throws Exception;

    List<StoreDto> Region(String address);

    StoreDto selectOne(Integer id);

    List<StoreDto> selectResultPage(SearchCondition sc);

    List<StoreDto> selectAllPage(SearchCondition sc);
    int count(SearchCondition sc);
    }



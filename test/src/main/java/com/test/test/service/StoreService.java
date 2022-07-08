package com.test.test.service;

import com.test.test.domain.SearchCondition;
import com.test.test.domain.StoreDto;

import java.util.List;

public interface StoreService {
    List<StoreDto> regionStore(String address);
     List<StoreDto>AllStore() throws Exception;
//     List<StoreDto> category(SearchCondition sc);
     StoreDto getStore(Integer id);

    List<StoreDto> getList(SearchCondition sc);


    }

package com.test.test.dao;

import com.test.test.domain.StoreDto;

import java.util.List;

public interface StoreDao {
    List<StoreDto> selectAll() throws Exception;
}

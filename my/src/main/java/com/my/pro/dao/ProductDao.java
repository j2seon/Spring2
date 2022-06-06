package com.my.pro.dao;

import com.my.pro.dto.ProductDto;

public interface ProductDao {
    int insert(ProductDto dto) throws Exception;
}

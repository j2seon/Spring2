package com.my.pro.service;

import com.my.pro.dto.ProductDto;

import java.util.List;

public interface ProductServie {
    int add(ProductDto dto) throws Exception;

    List<ProductDto> selectCateCode(String cateCode)throws Exception;


    }

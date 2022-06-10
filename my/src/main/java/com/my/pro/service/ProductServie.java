package com.my.pro.service;

import com.my.pro.dto.ProductDto;

import java.util.List;

public interface ProductServie {
    int add(ProductDto dto) throws Exception; // 상품 추가
    List<ProductDto> selectCateCode(String cateCode)throws Exception;
    List<ProductDto> selectAll() throws Exception ; //상품목록


    }

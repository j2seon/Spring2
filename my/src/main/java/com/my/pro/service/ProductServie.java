package com.my.pro.service;

import com.my.pro.dto.ProductDto;

import java.util.List;

public interface ProductServie {
    int add(ProductDto dto) throws Exception; // 상품 추가
    ProductDto read(Integer goodsNum)throws Exception;
    List<ProductDto> selectAll() throws Exception ; //상품목록

    int modify(ProductDto dto)throws Exception;

//    ProductDto read(Integer goodsNum)throws Exception;
    int remove(Integer goodsNum)throws Exception;


    }

package com.my.pro.dao;

import com.my.pro.dto.ProductDto;

import java.util.List;

public interface ProductDao {
    int insert(ProductDto dto) throws Exception;

   // List<ProductDto> selectAll()throws Exception;

    int count() throws Exception;

    List<ProductDto> selectCateCode(String cateCode)throws Exception;


    }

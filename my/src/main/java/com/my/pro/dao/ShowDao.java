package com.my.pro.dao;

import com.my.pro.dto.ProductDto;

import java.util.List;

public interface ShowDao {
    List<ProductDto> listSec(String cateCode) throws Exception;

    List<ProductDto> listFirst (String cateCodeRef)throws Exception;


    }

package com.my.pro.service;

import com.my.pro.domain.ProductDto;

import java.util.List;

public interface ShowService {

    List<ProductDto>getList (int tier, String cateCode) throws Exception;


    }

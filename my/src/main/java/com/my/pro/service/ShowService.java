package com.my.pro.service;

import com.my.pro.dto.ProductDto;

import java.util.List;

public interface ShowService {
       List<ProductDto> list(String code, Integer tier) throws Exception;


    }

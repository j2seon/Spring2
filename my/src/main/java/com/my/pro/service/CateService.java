package com.my.pro.service;

import com.my.pro.domain.CateDto;

import java.util.List;

public interface CateService {
    List<CateDto> categoryList() throws Exception;
}

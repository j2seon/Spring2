package com.my.pro.dao;

import com.my.pro.dto.CateDto;

import java.util.List;

public interface CateDao {
    List<CateDto> selectAll() throws Exception;
}

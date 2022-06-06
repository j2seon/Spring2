package com.my.pro.service;

import com.my.pro.dao.CateDao;
import com.my.pro.dto.CateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateServiceImple implements CateService {

    @Autowired
    CateDao cateDao;

    @Override
    public List<CateDto> categoryList()throws Exception{
        return cateDao.selectAll();
    }

}

package com.my.pro.service;

import com.my.pro.dao.ShowDao;
import com.my.pro.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowDao showDao;

    public List<ProductDto> list(String code, Integer tier) throws Exception {
        if(tier == 1){
            return showDao.listFirst(code);
        }else{
            return showDao.listSec(code);
        }
    }



}

package com.my.pro.service;

import com.my.pro.dao.ShowDao;
import com.my.pro.domain.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowDao showDao;

    public List<ProductDto>getList(int tier, String cateCode) throws Exception {

        if(tier==1){
              String cateCodeRef = cateCode;
              return showDao.listFirst(cateCodeRef);
        }else {
            return showDao.listSec(cateCode);
        }

    }



}

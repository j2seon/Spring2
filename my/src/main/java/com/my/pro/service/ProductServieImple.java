package com.my.pro.service;

import com.my.pro.dao.CateDao;
import com.my.pro.dao.ProductDao;
import com.my.pro.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServieImple implements ProductServie {

 @Autowired
 ProductDao productDao;

 @Autowired
 CateDao cateDao;

 @Override
 public int add(ProductDto dto)throws Exception{
     return productDao.insert(dto);
 }
 @Override
 public List<ProductDto> selectCateCode(String cateCode)throws Exception{
     return productDao.selectCateCode(cateCode);
 }

 @Override
 public List<ProductDto> selectAll() throws Exception {
    return productDao.selectAll();
 }


}

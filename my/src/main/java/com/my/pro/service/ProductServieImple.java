package com.my.pro.service;

import com.my.pro.dao.CateDao;
import com.my.pro.dao.ProductDao;
import com.my.pro.domain.ProductDto;
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
 public ProductDto read(Integer goodsNum)throws Exception{
     return productDao.selectNum(goodsNum);
 }

 @Override
 public List<ProductDto> selectAll() throws Exception {
    return productDao.selectAll();
 }
@Override
 public int modify(ProductDto dto)throws Exception{
  return productDao.update(dto);
 }
// @Override
// public ProductDto read(Integer goodsNum)throws Exception{
//   return productDao.select(goodsNum);
// }
@Override
public int remove(Integer goodsNum)throws Exception{
  return productDao.delete(goodsNum);
}


}

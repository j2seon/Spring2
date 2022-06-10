package com.my.pro.dao;

import com.my.pro.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SqlSession session;

    private static String namespace ="com.my.pro.dao.ProductMapper.";


    @Override
    public int insert(ProductDto dto)throws Exception{
        return session.insert(namespace+"insert",dto);
    }
//    @Override
//    public List<ProductDto> selectAll()throws Exception{
//        return session.selectList(namespace+"selectAll");
//    }
    @Override
    public int count()throws Exception{
        return session.selectOne(namespace+"count");
    }
    @Override
    public List<ProductDto> selectAll() throws Exception{
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public List<ProductDto> selectCateCode(String cateCode)throws Exception{
        return session.selectList(namespace+"selectCateCode",cateCode);
    }


}

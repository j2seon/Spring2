package com.my.pro.dao;

import com.my.pro.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SqlSession session;

    private static String namespace ="com.my.pro.dao.ProductMapper.";


    @Override
    public int insert(ProductDto dto)throws Exception{
        return session.insert(namespace+"insert",dto);

    }


}

package com.my.pro.dao;

import com.my.pro.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShowDaoImpl implements ShowDao {

    @Autowired
    private SqlSession session;

    private static String namespace ="com.my.pro.dao.ShowMapper.";

    @Override
    public List<ProductDto> listSec (String cateCode)throws Exception{
        return session.selectList(namespace+"listSec",cateCode);
    }
    @Override
    public List<ProductDto> listFirst (String cateCodeRef)throws Exception{
        return session.selectList(namespace+"listFirst",cateCodeRef);
    }
}

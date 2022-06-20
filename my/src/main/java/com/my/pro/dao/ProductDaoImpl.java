package com.my.pro.dao;

import com.my.pro.domain.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public ProductDto selectNum(Integer goodsNum)throws Exception{
        return session.selectOne(namespace+"selectNum",goodsNum);
    }
    @Override
    public int update(ProductDto dto)throws Exception{
        return session.update(namespace+"update",dto);
    }

    public int delete(Integer goodsNum)throws Exception{
        return session.delete(namespace+"delete",goodsNum);
    }


//    @Override
//    public ProductDto select(Integer goodsNum)throws Exception{
//        return session.selectOne(namespace+"select",goodsNum);
//    }


}

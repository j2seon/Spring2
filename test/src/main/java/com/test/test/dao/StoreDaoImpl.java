package com.test.test.dao;

import com.test.test.domain.SearchCondition;
import com.test.test.domain.StoreDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreDaoImpl implements StoreDao {

    @Autowired
    SqlSession session;

    private static String namespace = "com.test.test.dao.StoreMapper.";

    @Override
    public List<StoreDto> selectAll()throws Exception{
        return session.selectList(namespace+"selectAll");
    }
    @Override
    public List<StoreDto> Region(String address){
        return session.selectList(namespace+"Region",address);
    }

    @Override
    public StoreDto selectOne(Integer id){
        return session.selectOne(namespace+"selectOne",id);
    }
    @Override
    public List<StoreDto> selectAllPage(SearchCondition sc){
        return session.selectList(namespace+"selectAllPage",sc);
    }
    @Override
    public List<StoreDto> selectResultPage(SearchCondition sc){
        return session.selectList(namespace+"selectResultPage",sc);
    }
    @Override
    public int count(SearchCondition sc){
        return session.selectOne(namespace+"count",sc);
    }


}

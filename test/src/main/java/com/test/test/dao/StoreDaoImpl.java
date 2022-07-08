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

//    @Override
//    public List<StoreDto> searchStore1(SearchCondition sc){
//        return session.selectList(namespace+"searchStore1",sc);
//    }
//    @Override
//    public List<StoreDto> searchStore2(SearchCondition sc){
//        return session.selectList(namespace+"searchStore2",sc);
//    }


    @Override
    public StoreDto selectOne(Integer id){
        return session.selectOne(namespace+"selectOne",id);
    }
    @Override
    public List<StoreDto> selectResultpage(SearchCondition sc){
        return session.selectList(namespace+"selectResultpage",sc);
    }



}

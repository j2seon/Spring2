package com.test.test.dao;

import com.test.test.domain.SearchCondition;
import com.test.test.domain.TourDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourDaoImpl implements TourDao {

    @Autowired
    SqlSession session;

    private static String namespace = "com.test.test.dao.TourMapper.";

    @Override
    public List<TourDto> region(String address){
        return session.selectList(namespace+"region",address);
    }
    @Override
    public List<TourDto> selectAll(){
        return session.selectList(namespace+"selectAll");
    }
    @Override
    public int regionCount(String address){return session.selectOne(namespace+"regionCount",address);}
    public List<TourDto> test(SearchCondition sc){
        return session.selectList(namespace+"test",sc);
    }
    @Override
    public TourDto read(String no){
        return session.selectOne(namespace+"read",no);
    }
}

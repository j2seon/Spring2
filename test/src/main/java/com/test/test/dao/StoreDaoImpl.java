package com.test.test.dao;

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







}

package com.test.test.dao;


import com.test.test.domain.JoinDto;
import com.test.test.domain.JoinDto2;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JoindaoImpl implements Joindao {
    @Autowired
    SqlSession session;

    private static String namespace="joinMapper.";


    @Override
    public List<JoinDto> selectAll(){
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public List<JoinDto2> selectAll2(){
        return session.selectList(namespace+"selectAll2");
    }


}

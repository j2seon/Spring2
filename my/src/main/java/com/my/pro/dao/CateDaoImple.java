package com.my.pro.dao;

import com.my.pro.dto.CateDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CateDaoImple implements CateDao {

    @Autowired
    private SqlSession session;
    private static String namespace ="com.my.pro.dao.CateMapper.";



    @Override
    public List<CateDto> selectAll()throws Exception{
        return session.selectList(namespace+"selectAll");
    }

}

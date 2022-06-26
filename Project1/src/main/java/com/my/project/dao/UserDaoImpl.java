package com.my.project.dao;

import com.my.project.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    SqlSession session;

    private static String namespace = "com.my.pro.dao.UserMapper.";


    @Override
    public int insert(UserDto dto) throws Exception{
        return session.insert(namespace+"insert", dto);
    }//회원 추가하기

    @Override
    public List<UserDto> selectAll()throws Exception{
        return session.selectList(namespace+"selectAll");
    }//전체 회원보기

    @Override
    public UserDto select(String id) throws Exception{
        return session.selectOne(namespace+"select", id);
    } // 특정회원

    @Override
    public int count() throws Exception{
        return session.selectOne(namespace+"count");
    } // 전체 회원 수
    @Override
    public int delete(String id)throws Exception{
        return session.delete(namespace+"delete", id);
    }
    @Override
    public int deleteAll()throws  Exception{
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public UserDto check(UserDto dto)throws Exception {
        return session.selectOne(namespace+"check",dto);
    }

    @Override
    public int checkid(String id)throws Exception{
        return session.selectOne(namespace+"checkid",id);
    }

    @Override
    public int update(UserDto dto)throws Exception{
        return session.update(namespace+"update",dto);
    }




}

package com.my.pro.dao;

import com.my.pro.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public int delete(String id, String pwd) throws Exception{
        Map map = new HashMap();
        map.put("id", id);
        map.put("pwd", pwd);
        return session.delete(namespace+"delete",map);
    } //특정회원 삭제하기
    
    @Override
    public int deleteAll()throws Exception{
        return session.delete(namespace+"deleteAll");
    }// 전체 삭제하기

    public int update(UserDto dto)throws Exception{
        return session.update(namespace+"dto",dto);
    }// 회원정보 수정하기

    public UserDto select(String id)throws Exception{
        return session.selectOne(namespace+"select",id);
    }//특정 회원찾기
    
    public List<UserDao> selectAll()throws Exception{
        return session.selectList(namespace+"selectAll");
    }//전체 회원보기

}

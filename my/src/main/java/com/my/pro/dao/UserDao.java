package com.my.pro.dao;

import com.my.pro.dto.UserDto;

import java.util.List;

public interface UserDao {
    int insert(UserDto dto) throws Exception;//회원 추가

    int delete(String id, String pwd) throws Exception; //회원삭제

    int deleteAll() throws Exception; //전체삭제

    public int update(UserDto dto)throws Exception; //회원정보수정

    public UserDto select(String id)throws Exception; // 특정회원조회

    public List<UserDao> selectAll()throws Exception; //전체회원조회




    }

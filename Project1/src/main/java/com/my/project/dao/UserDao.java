package com.my.project.dao;


import com.my.project.domain.UserDto;

import java.util.List;

public interface UserDao {
    int insert(UserDto dto) throws Exception;//회원 추가하기


    List<UserDto> selectAll() throws Exception//전체 회원보기
    ;

    UserDto select(String id) throws Exception // 특정회원
    ;

    int count() throws Exception // 전체 회원 수
    ;

    int delete(String id) throws Exception;

    int deleteAll() throws Exception;

    UserDto check(UserDto dto) throws Exception;

    int checkid(String id)throws Exception;

    int update(UserDto dto)throws Exception;

    }

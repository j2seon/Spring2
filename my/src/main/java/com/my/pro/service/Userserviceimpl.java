package com.my.pro.service;

import com.my.pro.dao.UserDao;
import com.my.pro.dto.UserDto;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

@Service
public class Userserviceimpl implements Userservice {

    @Autowired
    UserDao userDao;

    @Override
    public void register(UserDto dto) throws Exception {
        userDao.insert(dto);
    }// 회원가입

    public UserDto login(UserDto dto) throws Exception {
        return userDao.selectch(dto);
    }




}

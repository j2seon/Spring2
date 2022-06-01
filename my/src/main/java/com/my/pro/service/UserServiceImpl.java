package com.my.pro.service;

import com.my.pro.dao.UserDao;
import com.my.pro.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;


    @Override
    public void register(UserDto dto) throws Exception {
        userDao.insert(dto);
    }

    @Override
    public UserDto login(UserDto dto) throws Exception {
        return userDao.check(dto);
    }

    @Override
    public int idCheck(String id) throws Exception {
        return userDao.checkid(id);
    }
}

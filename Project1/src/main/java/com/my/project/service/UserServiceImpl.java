package com.my.project.service;

import com.my.project.dao.UserDao;
import com.my.project.domain.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
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

    @Override
    public int userModify(UserDto dto)throws Exception{
        return userDao.update(dto);
    }
}

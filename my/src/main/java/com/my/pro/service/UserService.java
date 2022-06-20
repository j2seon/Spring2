package com.my.pro.service;

import com.my.pro.domain.UserDto;

public interface UserService {

    void register(UserDto dto) throws Exception;

    UserDto login(UserDto dto) throws Exception;

    int idCheck(String id) throws Exception;
     int userModify(UserDto dto)throws Exception;


}

package com.my.pro.service;

import com.my.pro.dto.UserDto;

public interface Userservice {
    void register(UserDto dto) throws Exception; //회원가입

    UserDto login(UserDto dto) throws Exception;
}
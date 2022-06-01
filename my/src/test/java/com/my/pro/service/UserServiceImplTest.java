package com.my.pro.service;

import com.my.pro.dao.UserDao;
import com.my.pro.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserServiceImplTest {

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    @Test
    public void register() {
    }

    @Test
    public void login() throws Exception {
        UserDto dto = new UserDto();
        dto.setPwd("aaaa");
        dto.setId("aaaa");
        UserDto dto2 = userService.login(dto);
        assertTrue(dto2!=null);

    }

    @Test
    public void idCheck() throws Exception {
        String id = "asdf";
        int cnt=userService.idCheck(id);
        assertTrue(cnt==0);


    }
}
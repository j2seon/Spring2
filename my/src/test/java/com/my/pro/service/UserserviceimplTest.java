package com.my.pro.service;

import com.my.pro.dao.UserDao;
import com.my.pro.dto.UserDto;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserserviceimplTest extends TestCase {

    @Autowired
    UserDao userDao;

    @Autowired
    Userservice userservice;

    @Test
    public void register() throws Exception {
    UserDto userDto = new UserDto("1111","asdf","asdf","asdf","asdf","asdf");
    userservice.register(userDto);

    assertTrue(userDao.select("1111").getId()=="1111");

    }
}
package com.my.pro.dao;

import com.my.pro.dto.UserDto;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoImplTest extends TestCase {

    @Autowired
    UserDao userDao;

    @Test
    public void testInsert() throws Exception {
        UserDto userDto = new UserDto("asdf","asdf","asdf","asdf","asdf","asdf");

        assertTrue(userDao.insert(userDto)==1);

    }

    public void testDelete() {
    }

    public void testDeleteAll() {
    }

    public void testUpdate() {
    }

    public void testSelect() {
    }

    public void testSelectAll() {
    }
}
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
        UserDto userDto = new UserDto("4567", "asdf", "asdf", "asdf", "asdf", "asdf");

        assertTrue(userDao.insert(userDto) == 1);

    }

    public void testDelete() throws Exception {
       int cnt = userDao.delete("4567","asdf");
        assertTrue(cnt==1);
    }

    @Test
    public void testDeleteAll() throws Exception {
        int cnt = userDao.deleteAll();
        assertTrue(cnt==  1);
    }

    public void testUpdate() {
    }

    @Test
    public void testSelect() throws Exception {
        UserDto userDto = new UserDto("kkkk", "asdf", "asdf", "asdf", "asdf", "asdf");
        assertTrue(userDao.insert(userDto)==1);
        System.out.println(userDto);

        UserDto user2 = userDao.select(userDto.getId());

        assertTrue(userDto.equals(user2));
        System.out.println(user2);

        user2 = userDao.select("kkkk");
        assertTrue(user2==null);
    }

    public void testSelectAll() {
    }

    @Test
    public void selectch() throws Exception {
        UserDto dd = userDao.select("zxcv");
        String a = dd.getId();
        String aa = dd.getPwd();

        UserDto dto = new UserDto();
        dto.setId("zxcv");
        dto.setPwd("zxcvzxcv");
        System.out.println(userDao.selectch(dto));
        assertTrue(a.equals(dto.getId()));
        assertTrue(aa.equals(dto.getPwd()));

    }
}
package com.my.pro.dao;

import com.my.pro.domain.UserDto;
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
        userDao.deleteAll();
        UserDto dto = new UserDto("aaaa", "aaaa", "aaaa", "aaa#aaa", "aaaa", "aaaa");
        int cnt = userDao.insert(dto);
        assertTrue(cnt == 1);
    }

    @Test
    public void testSelectAll() {
    }

    @Test
    public void Testselect() throws Exception {
        userDao.deleteAll();
        assertTrue(userDao.count() == 0);

        UserDto dto = new UserDto("aaaa", "aaaa", "aaaa", "aaa#aaa", "aaaa", "aaaa");
        assertTrue(userDao.insert(dto) == 1);

        UserDto user2 = userDao.select(dto.getId());
        System.out.println(user2);
        System.out.println(dto);
        assertTrue(dto.equals(user2));

        user2 = userDao.select("aaaaaaa");
        assertTrue(user2 == null);


    }

    @Test
    public void testCount() throws Exception {
        int cnt = userDao.count();
        assertTrue(cnt == 1);
    }

    @Test
    public void testDelete() throws Exception {
        userDao.delete("aaaa");
        assertTrue(userDao.count() == 0);

    }

    @Test
    public void testDeleteAll() {
    }

    @Test
    public void testCheck() throws Exception {
        UserDto dto = new UserDto();
        dto.setPwd("aaaa");
        dto.setId("aaaa");

        UserDto dto2 = userDao.check(dto);
        System.out.println(dto2);
        assertTrue(dto2 != null);

    }
    @Test
    public void testcheckid()throws Exception{
        String id ="aaaa";
        String id2 = "asdf";

       int cnt = userDao.checkid(id);
       assertTrue(cnt==1);
        int cnt2 = userDao.checkid(id2);
        assertTrue(cnt2==0);
    }
    @Test
    public void update()throws Exception {
        UserDto dto = new UserDto();
        dto.setPwd("aaaa");
        dto.setId("aaaa");

        UserDto dto2 = userDao.check(dto);
        dto2.setEmail("ddsd");
        dto2.setPhone("101010");
        int c = userDao.update(dto2);
        assertTrue(c == 1);

    }


}
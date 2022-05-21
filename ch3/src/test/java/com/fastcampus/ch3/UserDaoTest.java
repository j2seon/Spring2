package com.fastcampus.ch3;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class) //이게 있어서 ApplicationContext 객체를 만들지 않아도 생성해줌
                                        //그러고 context.xml에 bean으로 DataSource의 내용을 정해주면 됌
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})//xml설정파일 위치
public class UserDaoTest extends TestCase {

    @Autowired //오토와이어드를 이용해서 userdao를 주입해야한다.
    UserDao userDao;

    @Test
    public void testDeleteUser() {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2022,5,22);
        User user = new User("asas", "1111", "abc", "aaa@sas", new Date(cal.getTimeInMillis()), "fb", new Date(cal.getTimeInMillis()));
        int rowCnt = userDao.deleteUser(user.getId());
        assertTrue(rowCnt==1);
    }
    @Test
    public void testSelectUser() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2022,5,22);
        User user = new User("zx", "1111", "abc", "aaa@sas", new Date(cal.getTimeInMillis()), "fb", new Date(cal.getTimeInMillis()));
        userDao.insertUser(user);
        User user2 = userDao.selectUser(user.getId());
        System.out.println(user);
        System.out.println(user2);

        assertTrue(user.equals(user2));


    }
    @Test
    public void testInsertUser() {
        User user = new User("asas", "1111", "abc", "aaa@sas", new Date(), "fb", new Date());
        int rowCnt = userDao.insertUser(user);
        assertTrue(rowCnt==1);
    }
    @Test
    public void testUpdateUser() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.clear(); //클리어를 해줘야 시간정보가 찍히지 않는다 .
        cal.set(2022,5,22);

        userDao.deleteAll();
        User user = new User("asas", "1111", "abc", "aaa@sas", new Date(cal.getTimeInMillis()), "fb", new Date(cal.getTimeInMillis()));
        int rowCnt = userDao.insertUser(user);
        assertTrue(rowCnt == 1);

        user.setPwd("1111");
        user.setEmail("BBB@BBBB");
        rowCnt = userDao.updateUser(user);
        assertTrue(rowCnt == 1);

        User user2 = userDao.selectUser(user.getId());
        System.out.println(user);
        System.out.println(user2);
        assertTrue(user.equals(user2));
    }

    @Test
    public void testDeleteAll() {
    }
}
package com.test.test.dao;

import com.test.test.domain.SearchCondition;
import com.test.test.domain.TourDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TourDaoImplTest {

    @Autowired
    TourDao tourDao;

    @Test
    public void selectAll() {
        List<TourDto> list = tourDao.selectAll();
        System.out.println(list);
    }

    @Test
    public void regionCount() {
        String address="인천";
        int c=tourDao.regionCount(address);
        assertTrue(c==12);}

    @Test
    public void test1() {
        SearchCondition sc = new SearchCondition(2,10,"인천");
        List<TourDto>list = tourDao.regions(sc);
        System.out.println(list);
        assertTrue(list!=null);
    }

    @Test
    public void read() {
        int no = 1;
        TourDto dto = tourDao.read(no);
        System.out.println(dto);

    }

    @Test
    public void viewCount() {
        int no = 1;
        int c=tourDao.viewCount(no);
        assertTrue(c==1);
    }
}
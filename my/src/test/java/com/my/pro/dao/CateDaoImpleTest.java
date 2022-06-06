package com.my.pro.dao;

import com.my.pro.dto.CateDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CateDaoImpleTest {


    @Autowired
    CateDao cateDao;

    @Test
    public void selectAll() throws Exception {
        List<CateDto> list = cateDao.selectAll();
        System.out.println(list);
    }
}
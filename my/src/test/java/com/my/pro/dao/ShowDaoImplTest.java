package com.my.pro.dao;

import com.my.pro.domain.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ShowDaoImplTest {

    @Autowired
    ShowDao showDao;

    @Test
    public void listSec() throws Exception {
        List<ProductDto> lists = showDao.listSec("301");
        assertTrue(lists.size()==1);
    }
    @Test
    public void listFirst ()throws Exception{
        List<ProductDto> lists = showDao.listFirst("100");
        System.out.println(lists);
        assertTrue(lists.size()==7);

    }



    }
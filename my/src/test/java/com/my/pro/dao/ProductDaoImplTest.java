package com.my.pro.dao;

import com.my.pro.dto.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductDaoImplTest {

    @Autowired
    ProductDao productDao;

    @Test
    public void insert() throws Exception {
        ProductDto dto = new ProductDto(1,"에그마요","egg","에그마요","100",100,100,100,100,100,100);
        int c=productDao.insert(dto);
        assertTrue(c==1);

    }
}
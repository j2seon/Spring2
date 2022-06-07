package com.my.pro.service;

import com.my.pro.dto.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductServieImpleTest {


    @Autowired
    ProductServie productServie;

    @Test
    public void add()throws Exception {
        ProductDto dto = new ProductDto(100,"ss","ss","sss","100",1,2,3,4,5,6);
        int c=productServie.add(dto);
        assertTrue(c==1);
    }
}
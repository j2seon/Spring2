package com.my.pro.service;

import com.my.pro.dto.ProductDto;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ShowServiceImplTest {


    @Autowired
    ShowService showService;

    @Test
    public void list() throws Exception {
        Integer c=1;
       List<ProductDto> list = showService.list("100",c);
       assertTrue(list.size()==7);
        Integer c1=2;
        List<ProductDto> lis = showService.list("101",c1);
        System.out.println(lis);
        assertTrue(lis.size()==6);
    }

}
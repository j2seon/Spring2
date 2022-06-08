package com.my.pro.dao;

import com.my.pro.dto.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductDaoImplTest {

    @Autowired
    ProductDao productDao;

    @Test
    public void insert() throws Exception {
        ProductDto dto = new ProductDto(1,"에그마요","egg","에그마요","102","100",100,100,100,100,100,100);
        int c=productDao.insert(dto);
        assertTrue(c==1);

    }
//    @Test
//    public void selectAll()throws Exception{
//        List<ProductDto> list = productDao.selectAll();
//        System.out.println(list);
//        assertTrue(list.size()==4);
//    }

    @Test
    public void select()throws Exception{

    }
    @Test
    public void count()throws Exception{

    }


    @Test
    public void selectCateCode()throws Exception{
        String a = "101";
        List<ProductDto> li =productDao.selectCateCode(a);
        assertTrue(li.size()==2);
    }







    }
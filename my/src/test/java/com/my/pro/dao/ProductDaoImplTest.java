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
        ProductDto dto = new ProductDto(1,"a","aa","aa","101","100","asdf","asdf",1,1,1,1,1,1);
        productDao.insert(dto);

    }
    @Test
    public void selectAll()throws Exception{
        List<ProductDto> list = productDao.selectAll();
        System.out.println(list);
        assertTrue(list.size()==5);
    }
    @Test
    public void delete()throws Exception{
        Integer c = 11;
        int cc = productDao.delete(c);

        assertTrue(cc==1);

    }

    @Test
    public void count()throws Exception{

    }

    @Test
    public void selectCateCode()throws Exception{
        Integer goodsNum=3;
        ProductDto dto =productDao.selectNum(goodsNum);
        assertTrue(dto.getGoodsNum()==3);
    }







    }
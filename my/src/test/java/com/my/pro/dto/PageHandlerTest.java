package com.my.pro.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PageHandlerTest {


    @Test
    public void test1(){
        PageHandler ph =new PageHandler(250,10,10);
        System.out.println(ph.getEndNavi());
        System.out.println(ph.getStartNavi());
        assertTrue(ph.getEndNavi()==10);
        assertTrue(ph.getStartNavi()==1);
    }
}
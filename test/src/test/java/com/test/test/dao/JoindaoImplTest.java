package com.test.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class JoindaoImplTest {

    @Autowired
    Joindao joindao;

    @Test
    public void selectAll() {
        assertTrue( joindao.selectAll().size()==3);
    }

    @Test
    public void selectAll2() {
        assertTrue( joindao.selectAll2().size()==3);

    }
}
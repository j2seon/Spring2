package com.test.test.dao;

import com.test.test.domain.StoreDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class StoreDaoImplTest {

    @Autowired
    StoreDao storeDao;

    @Test
    public void selectAll() throws Exception {
        List<StoreDto> list = storeDao.selectAll();
        System.out.println(list);
    }
}
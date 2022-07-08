package com.test.test.service;

import com.test.test.domain.SearchCondition;
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
public class StoreServiceImplTest {


    @Autowired
    StoreService storeService;

    @Test
    public void regionStore() {
        String address="대전";
        List<StoreDto> list = storeService.regionStore(address);
        assertTrue(list.size()!=0);
        System.out.println(list);
    }

    @Test
    public void testRegionStore() {
    }

    @Test
    public void allStore() throws Exception {
        List<StoreDto> list = storeService.AllStore();
        assertTrue(list.size()!=0);
        System.out.println(list);
    }

//    @Test
//    public void category() {
//        SearchCondition sc= new SearchCondition("master");
//        SearchCondition sc2= new SearchCondition("holiday","1");
//        List<StoreDto> list1 = storeService.category(sc);
//        assertTrue(list1.size()!=0);
//        System.out.println("list1 : "+list1);
//
//    }
}
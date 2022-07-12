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
        String address="경상북도";
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

    @Test
    public void getList() {
        SearchCondition sc = new SearchCondition(1,10,"mainMenu","2");
        List<StoreDto> list = storeService.getList(sc);
        System.out.println(list);
    }

    @Test
    public void getCount() {
        SearchCondition sc = new SearchCondition(1,10,"holiday","6");
        int c = storeService.getCount(sc);
        System.out.println(c);
    }
}
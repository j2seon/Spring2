package com.test.test.dao;

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
public class StoreDaoImplTest {

    @Autowired
    StoreDao storeDao;

    @Test
    public void selectAll() throws Exception {
        List<StoreDto> list = storeDao.selectAll();
        System.out.println(list);
    }

    @Test
    public void region() {
        String region="경기도";
        List<StoreDto> list = storeDao.Region(region);
        assertTrue(list.size()!=0);
        System.out.println(list);
    }


//    @Test
//    public void searchStore1() {
//        SearchCondition sc = new SearchCondition("master");
//        List<StoreDto> list =storeDao.searchStore1(sc);
//        System.out.println(list);
//    }

////    @Test
//    public void searchStore2() {
//        SearchCondition sc = new SearchCondition("holiday","1");
//        List<StoreDto> list = storeDao.searchStore2(sc);
//        System.out.println(list);
//    }

    @Test
    public void selectOne() {
        int id = 2;
        StoreDto storeDto= storeDao.selectOne(id);
        System.out.println(storeDto);
        assertTrue(storeDto!=null);

    }

    @Test
    public void selectResultPage() {
        SearchCondition sc = new SearchCondition(1,10,"holiday","1");
        sc.setAmount(10);
        sc.setPageNum(1);
        System.out.println(sc);
        List<StoreDto>list = storeDao.selectResultPage(sc);
        assertTrue(list!=null);
        System.out.println(list);
    }

    @Test
    public void selectAllPage() {
        SearchCondition sc = new SearchCondition(1,10);
        List<StoreDto> list = storeDao.selectAllPage(sc);
        System.out.println(list);
    }

    @Test
    public void count() {
        SearchCondition sc = new SearchCondition(1,10);
        int c = storeDao.count(sc);
        System.out.println(c);
    }

    @Test
    public void storeListId() {

    }
}
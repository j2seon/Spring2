package com.my.pro.dao;

import com.my.pro.dto.BoardDto;
import com.my.pro.dto.SearchCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDaoImplTest {

    @Autowired
    BoardDao boardDao;


    @Test
    public void insert() throws Exception {
        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
        assertTrue(boardDao.insert(boardDto)==1);

        boardDto = new BoardDto("no title", "no content", "asdf");
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao .count()==2);

        boardDao.deleteAll();
        boardDto = new BoardDto("no title", "no content", "asdf");
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==1);
    }
    @Test
    public void insert2() throws Exception {
       for(int i=0; i<50; i++){
           BoardDto boardDto = new BoardDto("title"+i, "no content", "asdf");
           boardDao.insert(boardDto);
       }
    }

    @Test
    public void count() {

    }

    @Test
    public void select() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
        assertTrue(boardDao.insert(boardDto)==1);

        Integer bno = boardDao.selectAll().get(0).getBno();
        boardDto.setBno(bno);
        BoardDto boardDto2 = boardDao.select(bno);
        assertTrue(boardDto.equals(boardDto2));
    }

    @Test
    public void list() {
    }

    @Test
    public void deleteAll() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void increaseViewCnt() {
    }

    @Test
    public void testsearchSelectPage() throws Exception {
        boardDao.deleteAll();
        for(int i=1; i<=20; i++){
            BoardDto dto = new BoardDto("title"+i,"hi","asdf");
            boardDao.insert(dto);
        System.out.println(dto);
        }

        SearchCondition sc =new SearchCondition(1,10,"title2","T");
        List<BoardDto> list = boardDao.searchSelectPage(sc);
        assertTrue(list.size()==2);

    }
    @Test
    public void TestsearchResultCount() throws Exception {
        for(int i=1; i<=20; i++){
            BoardDto dto = new BoardDto("title"+i,"hi","asdf");
            boardDao.insert(dto);
            System.out.println(dto);
        }

        SearchCondition sc = new SearchCondition(1,10,"title2","T");
        int cnt = boardDao.searchResultCount(sc);
        assertTrue(cnt==2);

    }



}
package com.my.pro.service;

import com.my.pro.dto.BoardDto;
import com.my.pro.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardServiceImplTest {

    @Autowired
    BoardService boardService;

    @Test
    public void write() throws Exception {
        BoardDto boardDto = new BoardDto("no title", "no content", "aaaa");
        int cnt = boardService.write(boardDto);
        assertTrue(cnt==1);
    }

    @Test
    public void getCount() throws Exception {
        int cnt=boardService.getCount();
        assertTrue(cnt==2);

    }

    @Test
    public void getList() {
    }

    @Test
    public void read() throws Exception {
        Integer bno=boardService.getList().get(0).getBno();
       BoardDto dto =boardService.read(bno);
       BoardDto dto2=boardService.getList().get(0);
       assertTrue(dto.equals(dto2));
    }

    @Test
    public void modify() throws Exception {
        BoardDto dto=boardService.getList().get(0);
        dto.setContent("hi");
       int cnt = boardService.modify(dto);
        assertTrue(cnt==1);
    }

    @Test
    public void remove() throws Exception {
        Integer bno = 5;
        String writer="aaaa";
        int cnt=boardService.remove(bno,writer);
        assertTrue(cnt==1);
        int cnt2 = boardService.getCount();
        assertTrue(cnt2==1);
    }
}
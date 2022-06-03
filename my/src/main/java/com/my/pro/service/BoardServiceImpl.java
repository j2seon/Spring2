package com.my.pro.service;

import com.my.pro.dao.BoardDao;
import com.my.pro.dto.BoardDto;
import com.my.pro.dto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDao boardDao;

    @Override
    public int write(BoardDto dto) throws Exception {
        return boardDao.insert(dto);
    } // 게시물 등록

    @Override
    public int getCount() throws Exception{
        return boardDao.count();
    }//등록된 게시물의 총 숫자

    public List<BoardDto> getPage(Map map)throws Exception{
        return boardDao.selectPage(map);
    }

    @Override
    public List<BoardDto> getList() throws Exception {
        return boardDao.selectAll();
    } // 전체 게시물 출력

    @Override
    public BoardDto read(Integer bno) throws Exception {
       BoardDto dto = boardDao.select(bno);
       boardDao.increaseViewCnt(bno);
       return dto; //읽을 게시글 + 조회수 올리기
    }

    @Override
    public int modify(BoardDto dto)throws Exception{
        return boardDao.update(dto);
    }//게시글 수정하기

    @Override
    public int remove(Integer bno, String writer)throws Exception{
        return boardDao.delete(bno,writer);
    }
    @Override
    public List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception {
        return boardDao.searchSelectPage(sc);
    }
    @Override
    public int getSearchResultCount(SearchCondition sc)throws Exception{
        return boardDao.searchResultCount(sc);
    }

}

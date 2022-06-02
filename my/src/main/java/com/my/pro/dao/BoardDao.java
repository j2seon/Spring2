package com.my.pro.dao;

import com.my.pro.dto.BoardDto;

import java.util.List;
import java.util.Map;

public interface BoardDao {
    int insert(BoardDto dto) throws Exception;

    int count() throws Exception;

    BoardDto select(Integer bno) throws Exception;

    List<BoardDto> selectAll() throws Exception;

    int deleteAll();

    int delete(Integer bno, String writer) throws Exception;

    int update(BoardDto dto) throws Exception;

    int increaseViewCnt(Integer bno);

    List<BoardDto> selectPage(Map map)throws Exception;

    }

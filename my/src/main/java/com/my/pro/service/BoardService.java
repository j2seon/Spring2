package com.my.pro.service;

import com.my.pro.dto.BoardDto;
import com.my.pro.dto.SearchCondition;

import java.util.List;
import java.util.Map;

public interface BoardService {
    int write(BoardDto dto) throws Exception // 게시물 등록
    ;

    int getCount() throws Exception//등록된 게시물의 총 숫자
    ;

    List<BoardDto> getList() throws Exception // 전체 게시물 출력
    ;

    BoardDto read(Integer bno) throws Exception;//게시글 읽기

    int modify(BoardDto dto) throws Exception//게시글 수정하기
    ;

    int remove(Integer bno, String writer) throws Exception; // 게시글 삭제
    
    List<BoardDto> getPage(Map map) throws Exception; //게시글 페이징 처리용


    List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception;

    int getSearchResultCount(SearchCondition sc)throws Exception;


}
    

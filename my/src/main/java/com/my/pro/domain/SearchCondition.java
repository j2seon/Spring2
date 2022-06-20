package com.my.pro.domain;

import org.springframework.web.util.UriComponentsBuilder;

//원하는 페이지찾기 위한 클래스
public class SearchCondition {

    private Integer page=1; //페이지도 알아야겟지?
    private Integer rowCnt=10; //한페이지크기
    private Integer offset=0; //
    private String keyword=""; //
    private String option=""; // 제목, 이름 이런식으로 입력할 옵션


    public SearchCondition(){}
    public SearchCondition(Integer page, Integer rowCnt) {
        this(page, rowCnt, "", "");
    }
    public SearchCondition(Integer page, Integer rowCnt, String keyword, String option) {
        this.page = page;
        this.rowCnt = rowCnt;
        this.keyword = keyword;
        this.option = option;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }

    public Integer getOffset() {
        return (page-1)*rowCnt;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "page=" + page +
                ", rowCnt=" + rowCnt +
                ", offset=" + offset +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }

    //쿼리스트링 처리해주기
    public String getQueryString(Integer page){
        //요청있을때 page=1&rowCnt=10 ......
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("rowCnt", rowCnt)
                .queryParam("option", option)
                .queryParam("keyword", keyword)
                .build().toString();
    }
    public String getQueryString() {
        return getQueryString(page);
    }

}

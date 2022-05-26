package com.fastcampus.ch4.domain;

public class SearchCondition {
    //검색조건!
    private Integer page = 1; //현재 페이지
    private Integer pageSize = 10; // 페이지 사이즈
    private Integer offset = 0; //각 페이지당 시작하는 페이지
    private String keyword ="";
    private String option = ""; //옵션
    //기본생성자
    public SearchCondition(){}
    public SearchCondition(Integer page, Integer pageSize, String keyword, String option) {
        this.page = page;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.option = option;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return offset;
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
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }
}

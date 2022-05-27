package com.fastcampus.ch4.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
    //검색조건!
    private Integer page = 1; //현재 페이지
    private Integer pageSize = 10; // 페이지 사이즈
    //private Integer offset = 0; //각 페이지당 시작하는 페이지 >> iv로 주는 것보다 페이지에서 계산하게 적용하는 게 낫다. why? 계속 변경이되면 문제가 될수 있어서 set을 지정하지 x
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
        return (page-1)*pageSize; // 위의 값을 이용해서만! 값이 변할 수 있도록 설정한다.
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
                ", offset=" + getOffset() +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }
    //지정된 페이지를 보여주는 것도 필요해서 메개변수로 받는 값으로 지정하는 메소드 추가작성
    public String getQueryString(Integer page){ //페이지를 지정받으면 이걸씀.
        return UriComponentsBuilder.newInstance()
                .queryParam("page",page)
                .queryParam("pageSize", pageSize)
                .queryParam("option", option)
                .queryParam("keyword",keyword)
                .build().toString();
    }

    public String getQueryString(){ //페이지를 정해주지않으면 이걸 쓰고
        //요청있을 때 url에다가 다 값을 줘야함 ex) ?page=1&option=T& ... 이런식으로 적어야되는데 그걸 간단하게 할려고 메서드를만든다. UriComponentsBuilder를 이용한다.
        return getQueryString(page);
    }




//    public String getQueryString(){
//        //요청있을 때 url에다가 다 값을 줘야함 ex) ?page=1&option=T& ... 이런식으로 적어야되는데 그걸 간단하게 할려고 메서드를만든다. UriComponentsBuilder를 이용한다.
//       return UriComponentsBuilder.newInstance()
//                .queryParam("page",sc.getPage())
//                .queryParam("pageSize", sc.getPageSize())
//                .queryParam("option", sc.getOption())
//                .queryParam("keyword",sc.getKeyword())
//                .build().toString();
//    }
}

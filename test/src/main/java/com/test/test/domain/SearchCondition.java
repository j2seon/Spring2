package com.test.test.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {

    private Integer pageNum; //현재 페이지
    private Integer amount = 10; //한페이지에 나오는 게시물 숫자
    private String type; //타입에 따라 지정
    private String keyword; //넘어오는 키워드 값.
    public SearchCondition(){
        this(1,10);
    }
//    public SearchCondition(String type){
//        this.type = type;
//    }
//    public SearchCondition(String type, String keyword){
//        this.type = type;
//        this.keyword = keyword;
//    }

    public SearchCondition(Integer pageNum, Integer amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

//    public SearchCondition(Integer pageNum, Integer amount, String type, String keyword) {
//        this.pageNum = pageNum;
//        this.amount = amount;
//        this.type = type;
//        this.keyword = keyword;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

//    @Override
//    public String toString() {
//        return "SearchCondition{" +
//                "pageNum=" + pageNum +
//                ", amount=" + amount +
//                '}';
//    }


    @Override
    public String toString() {
        return "SearchCondition{" +
                "type='" + type + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }

    public String getQueryString(){
        return UriComponentsBuilder.newInstance()
                .queryParam("type",type)
                .queryParam("k", keyword)
                .build().toString();
    }

}

package com.test.test.domain;

public class PageHandler {
    private Integer startPage; //시작페이지
    private Integer endPage; //끝 페이지
    private boolean prev; //이전페이지
    private boolean next; //다음페이지
    private Integer totalCnt; // 전체 페이지
    private SearchCondition sc; //현재페이지,출력될 페이지 수!

    public PageHandler(SearchCondition sc, Integer totalCnt){
        this.sc = sc;
        this.totalCnt = totalCnt;
        this.endPage = (int) (Math.ceil(sc.getPageNum() / 10.0)) * 10;
        this.startPage= this.endPage-9;
        Integer realEnd = (int) (Math.ceil((totalCnt * 1.0)/ sc.getAmount()));
        if(realEnd < endPage){
            this.endPage = realEnd;
        }
        this.prev = this.startPage > 1;
        this.next = this.endPage< realEnd;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public SearchCondition getSc() {
        return sc;
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                ", totalCnt=" + totalCnt +
                ", sc=" + sc +
                '}';
    }
}

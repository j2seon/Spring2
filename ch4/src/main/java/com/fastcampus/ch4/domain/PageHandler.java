package com.fastcampus.ch4.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class PageHandler {
//    private int pageSize; // 한 페이지의 크기
//    private String option;
//    private String keyword; 위에 옵션과 키워드가 추가되면서 SearchCondition으로 바꿨다.
//    private int page; //현재페이지

    private SearchCondition sc;
    private int totalCnt; // 총 개시물 갯수
    private int totalPage; // 전체 페이지의 개수
    private int naviSize = 10; // 페이지 네비게이션의 크기
    private int beginPage; //네비게이션의 첫번째 페이지
    private int endPage; //네비게이션의 마지막 페이지
    private boolean showPrev; // 이전페이지로 이동하는 링크를 보여줄 것인지의 여부
    private boolean showNext; // 다음페이지로 이동하는 링크를 보여줄 것인지의 여부

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public SearchCondition getSc() {
        return sc;
    }

    public void setSc(SearchCondition sc) {
        this.sc = sc;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public PageHandler(int totalCnt, SearchCondition sc){
        this.totalCnt = totalCnt;
        this.sc = sc;
        doPaging(totalCnt , sc);
    }

    public void doPaging(int totalCnt, SearchCondition sc){ //페이지 계산하는데에 필요하다~
        this.totalCnt = totalCnt;

        totalPage = (int)Math.ceil(totalCnt / (double)sc.getPageSize()); // 총 페이지의 개수는 총 게시물의 개수/한페이지의 크기 반올림을 하기때문에
        beginPage = (sc.getPage()-1) / naviSize * naviSize + 1; //시작페이지
        endPage = Math.min(beginPage + naviSize -1, totalPage); //끝나는 페이지가 totalpage가 작을 수 있다. >  Math.min으로 둘중에 작은거적용
        //삼항연산자 가능
        showPrev = beginPage != 1; //1일때 보이지 않아야한다. 1일 때 false
        showNext = endPage != totalPage; //endpage 가 총 페이지개수랑 같지 않아야 된다.

    }


    //페이지네이게이션을 출력하는 메서드
    void print(){
        System.out.println("page = " + sc.getPage()); //현재 페이지
        System.out.println(showPrev? "[PREV]" : "" ); // showPrev가 true이면 보여주고 아니면 빈문자열
        for(int i = beginPage; i <= endPage; i++){ //beginPage부터~ endPage까지 출력한다.
            System.out.print(i + " ");
        }
        System.out.println(showNext? " [Next]" : "");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "sc=" + sc +
                ", totalCnt=" + totalCnt +
                ", totalPage=" + totalPage +
                ", naviSize=" + naviSize +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}

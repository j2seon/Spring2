package com.my.pro.domain;

public class PageHandler {

//    private int page; //현재 페이지
//    private int rowCnt; // 한페이지에서 출력될 게시물의 수
//    private String option; //검색할 옵션
//    private String keyword; //검색하는 키워드


    private  SearchCondition sc;
    private int totalCnt; // 출력될 게시글의 개수

    public final int naviSize=10; // 네비게이션 크기
    private int startNavi; //네비게이션 시작
    private int endNavi; //네비게이션 끝
    private int totalPage; // 전체페이지 수 (네비게이션 총 수)

    private boolean showPrev = false; // 이전페이지 이동하는링크
    private boolean showNext = false; //다음페이지 이동하는 링크

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }


    public int getNaviSize() {
        return naviSize;
    }


    public int getStartNavi() {
        return startNavi;
    }

    public void setStartNavi(int startNavi) {
        this.startNavi = startNavi;
    }
    public SearchCondition getSc() {
        return sc;
    }
    public void setSc(SearchCondition sc) {
        this.sc = sc;
    }

    public int getEndNavi() {
        return endNavi;
    }

    public void setEndNavi(int endNavi) {
        this.endNavi = endNavi;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
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

    public PageHandler(int totalCnt, Integer page) {
        this(totalCnt, new SearchCondition(page, 10));
    }

    public PageHandler(int totalCnt, Integer page, Integer rowCnt) {
        this(totalCnt, new SearchCondition(page, rowCnt));
    }
    public PageHandler(int totalCnt, SearchCondition sc){
        this.totalCnt=totalCnt;
        this.sc=sc;
        doPaging(totalCnt,sc);
    }

    //페이지 계산하는데 필요한 생성자만들기>>> 메소드로
    public void doPaging(int totalCnt ,SearchCondition sc){
        this.totalPage = totalCnt / sc.getRowCnt() + (totalCnt % sc.getRowCnt()==0? 0:1); // 전체 페이지/출력될 게시물
        this.sc.setPage(Math.min(sc.getPage(), totalPage));
        this.startNavi = (this.sc.getPage() -1) / naviSize * naviSize + 1; // 11 -> 11, 10 -> 1, 15->11. 따로 떼어내서 테스트
        this.endNavi = Math.min(startNavi + naviSize - 1, totalPage);
       // (int) (Math.ceil(page / (double)rowCnt) *rowCnt ); 올림하고 rowCnt 곱하는거
       this.showPrev = startNavi !=1; //1이 아니여야 보인다.
        this.showNext =  endNavi != totalPage; // endNavi가 총페이지 수랑 같으면 false

    }
//    void print(){
//        System.out.println("page = "+ sc.getPage());
//        System.out.print(showPrev? "<" : "");
//        for(int i=startNavi; i<=endNavi; i++){
//            System.out.print(i+ " ");
//        }
//        System.out.print(showNext? ">":"");
//    }


    public String toString() {
        return "PageHandler{" +
                "sc=" + sc +
                ", totalCnt=" + totalCnt +
                ", naviSize=" + naviSize +
                ", startNavi=" + startNavi +
                ", endNavi=" + endNavi +
                ", totalPage=" + totalPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }




}

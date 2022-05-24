package com.fastcampus.ch4.domain;

public class PageHandler {
    private int totalCnt; // 총 개시물 갯수
    private int pageSize; // 한 페이지의 크기
    private int naviSize = 10; // 페이지 네비게이션의 크기
    private int totalPage; // 전체 페이지의 개수
    private int page; //현재페이지
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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

    //셍성자로 페이지 사이즈를정하지 않으면 10 으로
    public PageHandler(int totalCnt, int page){
        this(totalCnt, page,10);
    }


    public PageHandler(int totalCnt, int page, int pageSize){ //페이지 계산하는데에 필요하다~
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int)Math.ceil(totalCnt / (double)pageSize); // 총 페이지의 개수는 총 게시물의 개수/한페이지의 크기 반올림을 하기때문에
        beginPage = page / naviSize * naviSize + 1; //시작페이지
        endPage = Math.min(beginPage + naviSize -1, totalPage); //끝나는 페이지가 totalpage가 작을 수 있다. >  Math.min으로 둘중에 작은거적용
        //삼항연산자 가능
        showPrev = beginPage != 1; //1일때 보이지 않아야한다. 1일 때 false
        showNext = endPage != totalPage; //endpage 가 총 페이지개수랑 같지 않아야 된다.
    }

    //페이지네이게이션을 출력하는 메서드
    void print(){
        System.out.println("page = " + page); //현재 페이지
        System.out.println(showPrev? "[PREV]" : "" ); // showPrev가 true이면 보여주고 아니면 빈문자열
        for(int i = beginPage; i <= endPage; i++){ //beginPage부터~ endPage까지 출력한다.
            System.out.print(i + " ");
        }
        System.out.println(showNext? " [Next]" : "");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalCnt=" + totalCnt +
                ", pageSize=" + pageSize +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", page=" + page +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}

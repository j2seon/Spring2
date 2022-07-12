package com.test.test.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


public class TourDto {

    private Integer no; //번호
    private Integer startPoint; //출발지
    private Integer endPoint; //도착지
    private String wayPoint; //경유지
    private String content; //내용
    private String title; //제목
    private Date reg_date; // 작성일
//    String writer; //작성자
    private Integer view_cnt; //조회수
    private String tourImg; //투어메인이미지
    private Integer likes; //좋아요
    private String address;

    public TourDto(){}
    public TourDto(String address){
        this.address=address;
    }
    public TourDto(Integer no, Integer startPoint, Integer endPoint, String wayPoint, String content, String title, Date reg_date, Integer view_cnt, String tourImg, Integer likes,String address) {
        this.no = no;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.wayPoint = wayPoint;
        this.content = content;
        this.title = title;
        this.reg_date = reg_date;
        this.view_cnt = view_cnt;
        this.tourImg = tourImg;
        this.likes = likes;
        this.address= address;
    }

    @Override
    public String toString() {
        return "TourDto{" +
                "no=" + no +
                ", startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                ", wayPoint='" + wayPoint + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", reg_date=" + reg_date +
                ", view_cnt=" + view_cnt +
                ", tourImg='" + tourImg + '\'' +
                ", likes=" + likes +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Integer startPoint) {
        this.startPoint = startPoint;
    }

    public Integer getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Integer endPoint) {
        this.endPoint = endPoint;
    }

    public String getWayPoint() {
        return wayPoint;
    }

    public void setWayPoint(String wayPoint) {
        this.wayPoint = wayPoint;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Integer getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(Integer view_cnt) {
        this.view_cnt = view_cnt;
    }

    public String getTourImg() {
        return tourImg;
    }

    public void setTourImg(String tourImg) {
        this.tourImg = tourImg;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

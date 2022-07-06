package com.test.test.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class TourDto {

    Integer num; //투어번호 시퀀스이용
    String city; // 시,도
    Integer startPoint; //출발지
    Integer endPoint; //도착지
    String wayPoint; //경유지
    String content; //내용
    String title; //제목
    Date write_date; // 작성일
    String writer; //작성자
    Integer view_cnt; //조회수
    String tourImg; //투어메인이미지
    

}

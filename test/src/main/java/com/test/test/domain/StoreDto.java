package com.test.test.domain;



import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;


public class StoreDto {

    Integer id;
    String gu;
    Date reg_date;
    Integer good;
    Integer holiday;
    Double lat;
    Double lon;
    String address;
    Integer post_num;
    String storeName;
    String franchise;
    String master;
    String eat;
    String corps;
    String mainimg;
    Integer mainMenu;

    public StoreDto(){}


    @Override
    public String toString() {
        return "StoreDto{" +
                "id=" + id +
                ", gu='" + gu + '\'' +
                ", reg_date=" + reg_date +
                ", good=" + good +
                ", holiday=" + holiday +
                ", lat=" + lat +
                ", lon=" + lon +
                ", address='" + address + '\'' +
                ", post_num=" + post_num +
                ", storeName='" + storeName + '\'' +
                ", franchise='" + franchise + '\'' +
                ", master='" + master + '\'' +
                ", eat='" + eat + '\'' +
                ", corps='" + corps + '\'' +
                ", mainimg='" + mainimg + '\'' +
                ", mainMenu=" + mainMenu +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public Integer getHoliday() {
        return holiday;
    }

    public void setHoliday(Integer holiday) {
        this.holiday = holiday;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPost_num() {
        return post_num;
    }

    public void setPost_num(Integer post_num) {
        this.post_num = post_num;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public String getMainimg() {
        return mainimg;
    }

    public void setMainimg(String mainimg) {
        this.mainimg = mainimg;
    }

    public Integer getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(Integer mainMenu) {
        this.mainMenu = mainMenu;
    }

    public String getQueryString(Integer id){
        return UriComponentsBuilder.newInstance()
                .queryParam("mainMenu",mainMenu)
                .queryParam("franchise",franchise)
                .queryParam("eat",eat)
                .queryParam("master",master)
                .queryParam("crops",corps)
                .queryParam("holiday",holiday)
                .build().toString();
    }
    public String getQueryString(){
        return getQueryString(id);
    }
}

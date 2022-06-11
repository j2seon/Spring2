package com.my.pro.dto;

import java.util.Date;
import java.util.Objects;

public class ProductDto {
    private Integer goodsNum; //번호 자동증가.
    private Integer price; //가격
    private String goodsName; // 이름
    private String subName; //영어이름
    private String content; // 내용
    private String cateCode; //카테고리 코드
    private String cateCodeRef;
    private String gdImg;

    private String gdThum;
    private Integer energy; // 열랑
    private Integer protein; //단백질
    private Integer per; //중량
    private Integer sodium; // 나트륨
    private Integer suger; //당류
    private Integer fat; //지방
    private Date reg_date;
    private Date up_date;

    private String cateName; // 받을거....

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }


    public ProductDto() {
    }

    public ProductDto(int goodsNum, String cateCode, String cateCodeRef) {
        this.goodsNum = goodsNum;
        this.cateCode = cateCode;
        this.cateCodeRef = cateCodeRef;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "goodsNum=" + goodsNum +
                ", price=" + price +
                ", goodsName='" + goodsName + '\'' +
                ", subName='" + subName + '\'' +
                ", content='" + content + '\'' +
                ", cateCode='" + cateCode + '\'' +
                ", cateCodeRef='" + cateCodeRef + '\'' +
                ", gdImg='" + gdImg + '\'' +
                ", gdThum='" + gdThum + '\'' +
                ", energy=" + energy +
                ", protein=" + protein +
                ", per=" + per +
                ", sodium=" + sodium +
                ", suger=" + suger +
                ", fat=" + fat +
                ", reg_date=" + reg_date +
                ", up_date=" + up_date +
                ", cateName='" + cateName + '\'' +
                '}';
    }

    public ProductDto(Integer price, String goodsName, String subName, String content, String cateCode, String cateCodeRef, String gdImg, String gdThum, Integer energy, Integer protein, Integer per, Integer sodium, Integer suger, Integer fat) {
        this.price = price;
        this.goodsName = goodsName;
        this.subName = subName;
        this.content = content;
        this.cateCode = cateCode;
        this.cateCodeRef = cateCodeRef;
        this.gdImg = gdImg;
        this.gdThum = gdThum;
        this.energy = energy;
        this.protein = protein;
        this.per = per;
        this.sodium = sodium;
        this.suger = suger;
        this.fat = fat;
    }

    public ProductDto(Integer goodsNum, String goodsName, String gdImg, String gdThum, String cateCode, String cateCodeRef, String content) {
        this.goodsNum = goodsNum;
        this.goodsName = goodsName;
        this.gdImg = gdImg;
        this.gdThum = gdThum;
        this.cateCode = cateCode;
        this.cateCodeRef = cateCodeRef;
        this.content = content;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public String getCateCodeRef() {
        return cateCodeRef;
    }

    public void setCateCodeRef(String cateCodeRef) {
        this.cateCodeRef = cateCodeRef;
    }

    public String getGdImg() {
        return gdImg;
    }

    public void setGdImg(String gdImg) {
        this.gdImg = gdImg;
    }

    public String getGdThum() {
        return gdThum;
    }

    public void setGdThum(String gdThum) {
        this.gdThum = gdThum;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getPer() {
        return per;
    }

    public void setPer(Integer per) {
        this.per = per;
    }

    public Integer getSodium() {
        return sodium;
    }

    public void setSodium(Integer sodium) {
        this.sodium = sodium;
    }

    public Integer getSuger() {
        return suger;
    }

    public void setSuger(Integer suger) {
        this.suger = suger;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Date getUp_date() {
        return up_date;
    }

    public void setUp_date(Date up_date) {
        this.up_date = up_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto)) return false;
        ProductDto dto = (ProductDto) o;
        return goodsNum == dto.goodsNum && Objects.equals(price, dto.price) && Objects.equals(goodsName, dto.goodsName) && Objects.equals(subName, dto.subName) && Objects.equals(content, dto.content) && Objects.equals(cateCode, dto.cateCode) && Objects.equals(cateCodeRef, dto.cateCodeRef) && Objects.equals(gdImg, dto.gdImg) && Objects.equals(gdThum, dto.gdThum) && Objects.equals(energy, dto.energy) && Objects.equals(protein, dto.protein) && Objects.equals(per, dto.per) && Objects.equals(sodium, dto.sodium) && Objects.equals(suger, dto.suger) && Objects.equals(fat, dto.fat) && Objects.equals(reg_date, dto.reg_date) && Objects.equals(up_date, dto.up_date) && Objects.equals(cateName, dto.cateName);
    }

}



package com.my.pro.dto;

import java.util.Date;
import java.util.Objects;

public class ProductDto {
    private int goodsNum; //번호 자동증가.
    private int price; //가격
    private String goodsName; // 이름
    private String subName; //영어이름
    private String content; // 내용
    private String cateCode; //카테고리 코드
    private String cateCodeRef;
    private String gdImg;
    private int energy; // 열랑
    private int protein; //단백질
    private int per; //중량
    private int sodium; // 나트륨
    private int suger; //당류
    private int fat; //지방
    private Date reg_date;
    private Date up_date;

    private String cateName; // 받을거....

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public ProductDto(int price, String goodsName, String subName, String content, String cateCode, String cateCodeRef, int energy, int protein, int per, int sodium, int suger, int fat) {
        this.price = price;
        this.goodsName = goodsName;
        this.subName = subName;
        this.content = content;
        this.cateCode = cateCode;
        this.cateCodeRef = cateCodeRef;
        this.energy = energy;
        this.protein = protein;
        this.per = per;
        this.sodium = sodium;
        this.suger = suger;
        this.fat = fat;
    }

    public String getGdImg() {
        return gdImg;
    }

    public void setGdImg(String gdImg) {
        this.gdImg = gdImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto)) return false;
        ProductDto that = (ProductDto) o;
        return goodsNum == that.goodsNum && price == that.price && energy == that.energy && protein == that.protein && per == that.per && sodium == that.sodium && suger == that.suger && fat == that.fat && Objects.equals(goodsName, that.goodsName) && Objects.equals(subName, that.subName) && Objects.equals(content, that.content) && Objects.equals(cateCode, that.cateCode) && Objects.equals(cateCodeRef, that.cateCodeRef) && Objects.equals(gdImg, that.gdImg) && Objects.equals(reg_date, that.reg_date) && Objects.equals(up_date, that.up_date) && Objects.equals(cateName, that.cateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsNum, price, goodsName, subName, content, cateCode, cateCodeRef, gdImg, energy, protein, per, sodium, suger, fat, reg_date, up_date, cateName);
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

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getPer() {
        return per;
    }

    public void setPer(int per) {
        this.per = per;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getSuger() {
        return suger;
    }

    public void setSuger(int suger) {
        this.suger = suger;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
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
}

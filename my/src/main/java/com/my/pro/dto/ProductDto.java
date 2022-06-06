package com.my.pro.dto;

import java.util.Date;
import java.util.Objects;

public class ProductDto {
    private int goodsNum; //번호 자동증가.
    private int price; //가격
    private String goodsName; // 이름
    private String subName; //영어이름
    private int stock; // 수량 필요할려나?
    private String content; // 내용
    private String cateCode; //카테고리 코드
    private String cateCodeRef;
    private int energy; // 열랑
    private int protein; //단백질
    private int per; //중량
    private int sodium; // 나트륨
    private int suger; //당류
    private int fat; //지방
    private Date reg_date;
    private Date up_date;

    public ProductDto(){};
    public ProductDto(int price, String goodsName, String subName, int stock, String content, String cateCode, String cateCodeRef, int energy, int protein, int per, int sodium, int suger, int fat) {
        this.price = price;
        this.goodsName = goodsName;
        this.subName = subName;
        this.stock = stock;
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

    @Override
    public String toString() {
        return "ProductDto{" +
                "goodsNum=" + goodsNum +
                ", price=" + price +
                ", goodsName='" + goodsName + '\'' +
                ", subName='" + subName + '\'' +
                ", stock=" + stock +
                ", content='" + content + '\'' +
                ", cateCode='" + cateCode + '\'' +
                ", cateCodeRef='" + cateCodeRef + '\'' +
                ", energy=" + energy +
                ", protein=" + protein +
                ", per=" + per +
                ", sodium=" + sodium +
                ", suger=" + suger +
                ", fat=" + fat +
                ", reg_date=" + reg_date +
                ", up_date=" + up_date +
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public String cateCodeRef() {
        return cateCodeRef;
    }

    public void setCateCodRef(String cateCodeRef) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto)) return false;
        ProductDto that = (ProductDto) o;
        return goodsNum == that.goodsNum && price == that.price && stock == that.stock && energy == that.energy && protein == that.protein && per == that.per && sodium == that.sodium && suger == that.suger && fat == that.fat && Objects.equals(goodsName, that.goodsName) && Objects.equals(subName, that.subName) && Objects.equals(content, that.content) && Objects.equals(cateCode, that.cateCode) && Objects.equals(cateCodeRef, that.cateCodeRef) && Objects.equals(reg_date, that.reg_date) && Objects.equals(up_date, that.up_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsNum, price, goodsName, subName, stock, content, cateCode, cateCodeRef, energy, protein, per, sodium, suger, fat, reg_date, up_date);
    }
}

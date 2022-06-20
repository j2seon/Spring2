package com.my.pro.domain;

public class InfoUmageDto {
    private String uploadPath; //파일 경로
    private String uuid; // 구분자
    private String filName; //파일이름
    private int goodsNum; // 상품 id fr 외래키 지정예정

    public String getUploadPath() {
        return uploadPath;
    }

    @Override
    public String toString() {
        return "InfoUmageDto{" +
                "uploadPath='" + uploadPath + '\'' +
                ", uuid='" + uuid + '\'' +
                ", filName='" + filName + '\'' +
                ", goodsNum=" + goodsNum +
                '}';
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFilName() {
        return filName;
    }

    public void setFilName(String filName) {
        this.filName = filName;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }
}

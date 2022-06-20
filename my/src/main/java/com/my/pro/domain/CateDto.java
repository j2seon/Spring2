package com.my.pro.domain;

import java.util.Objects;

public class CateDto {
    private int tier; //등급
    private String cateName;//카테고리이름
    private String cateCode; //카테고리 코드
    private String cateCodeRef; //카테고리 서브

    public CateDto(){}; // 기본생성자
    
    public CateDto(int tier, String cateName, String cateCode) {
        this.tier = tier;
        this.cateName = cateName;
        this.cateCode = cateCode;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
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

    @Override
    public String toString() {
        return "CateDto{" +
                "tier=" + tier +
                ", cateName='" + cateName + '\'' +
                ", cateCode='" + cateCode + '\'' +
                ", cateCodeRef='" + cateCodeRef + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CateDto)) return false;
        CateDto cateDto = (CateDto) o;
        return tier == cateDto.tier && Objects.equals(cateName, cateDto.cateName) && Objects.equals(cateCode, cateDto.cateCode) && Objects.equals(cateCodeRef, cateDto.cateCodeRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tier, cateName, cateCode, cateCodeRef);
    }
}

package com.zeyushen.springboot01.app.model;

import org.springframework.stereotype.Component;

@Component
public class CustomerInfoPojo {
    private Integer cId;

    private String cName;

    private String cSex;

    private Integer cAge;

    private String cVocation;

    private String cType;

    private String cDegree;

    private String cLevel;

    private String cEmail;

    private String cRegion;

    private String cAddress;

    private String cDescribe;

    private String cPhoto;

    private String cPhone;

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex == null ? null : cSex.trim();
    }

    public Integer getcAge() {
        return cAge;
    }

    public void setcAge(Integer cAge) {
        this.cAge = cAge;
    }

    public String getcVocation() {
        return cVocation;
    }

    public void setcVocation(String cVocation) {
        this.cVocation = cVocation == null ? null : cVocation.trim();
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public String getcDegree() {
        return cDegree;
    }

    public void setcDegree(String cDegree) {
        this.cDegree = cDegree == null ? null : cDegree.trim();
    }

    public String getcLevel() {
        return cLevel;
    }

    public void setcLevel(String cLevel) {
        this.cLevel = cLevel == null ? null : cLevel.trim();
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }

    public String getcRegion() {
        return cRegion;
    }

    public void setcRegion(String cRegion) {
        this.cRegion = cRegion == null ? null : cRegion.trim();
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
    }

    public String getcDescribe() {
        return cDescribe;
    }

    public void setcDescribe(String cDescribe) {
        this.cDescribe = cDescribe == null ? null : cDescribe.trim();
    }

    public String getcPhoto() {
        return cPhoto;
    }

    public void setcPhoto(String cPhoto) {
        this.cPhoto = cPhoto == null ? null : cPhoto.trim();
    }
}
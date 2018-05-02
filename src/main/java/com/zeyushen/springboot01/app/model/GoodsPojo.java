package com.zeyushen.springboot01.app.model;

import org.springframework.stereotype.Component;

@Component
public class GoodsPojo {
    private String gId;

    private Integer sId;

    private String gName;

    private Float gPrice;

    private Float gCosting;

    private String gAuthor;

    private String gSpecification;

    private String gRemark;

    private String gStatus;

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId == null ? null : gId.trim();
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public Float getgPrice() {
        return gPrice;
    }

    public void setgPrice(Float gPrice) {
        this.gPrice = gPrice;
    }

    public Float getgCosting() {
        return gCosting;
    }

    public void setgCosting(Float gCosting) {
        this.gCosting = gCosting;
    }

    public String getgAuthor() {
        return gAuthor;
    }

    public void setgAuthor(String gAuthor) {
        this.gAuthor = gAuthor == null ? null : gAuthor.trim();
    }

    public String getgSpecification() {
        return gSpecification;
    }

    public void setgSpecification(String gSpecification) {
        this.gSpecification = gSpecification == null ? null : gSpecification.trim();
    }

    public String getgRemark() {
        return gRemark;
    }

    public void setgRemark(String gRemark) {
        this.gRemark = gRemark == null ? null : gRemark.trim();
    }

    public String getgStatus() {
        return gStatus;
    }

    public void setgStatus(String gStatus) {
        this.gStatus = gStatus == null ? null : gStatus.trim();
    }
}
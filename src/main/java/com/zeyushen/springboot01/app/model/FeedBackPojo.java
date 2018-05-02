package com.zeyushen.springboot01.app.model;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class FeedBackPojo {
    private Integer fId;

    private Integer cId;

    private Integer sId;

    private String fTitle;

    private String fType;

    private String fDescript;

    private Date fAddtime;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getfTitle() {
        return fTitle;
    }

    public void setfTitle(String fTitle) {
        this.fTitle = fTitle == null ? null : fTitle.trim();
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType == null ? null : fType.trim();
    }

    public String getfDescript() {
        return fDescript;
    }

    public void setfDescript(String fDescript) {
        this.fDescript = fDescript == null ? null : fDescript.trim();
    }

    public Date getfAddtime() {
        return fAddtime;
    }

    public void setfAddtime(Date fAddtime) {
        this.fAddtime = fAddtime;
    }
}
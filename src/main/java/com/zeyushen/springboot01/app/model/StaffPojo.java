package com.zeyushen.springboot01.app.model;

import org.springframework.stereotype.Component;

@Component
public class StaffPojo {
    private Integer sId;

    private Integer dId;

    private String sTname;

    private String tPhone;

    private String tAddress;

    private String sLevel;

    public String getsLevel() {
        return sLevel;
    }

    public void setsLevel(String sLevel) {
        this.sLevel = sLevel;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getsTname() {
        return sTname;
    }

    public void setsTname(String sTname) {
        this.sTname = sTname == null ? null : sTname.trim();
    }

    public String gettPhone() {
        return tPhone;
    }

    public void settPhone(String tPhone) {
        this.tPhone = tPhone == null ? null : tPhone.trim();
    }

    public String gettAddress() {
        return tAddress;
    }

    public void settAddress(String tAddress) {
        this.tAddress = tAddress == null ? null : tAddress.trim();
    }
}
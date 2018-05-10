package com.zeyushen.springboot01.app.model;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class PactInfoPojo {
    private Integer pId;

    private Integer cId;

    private Integer sId;

    private String pTitle;

    private String pType;

    private Date pSigningdate;

    private Date pExecdate;

    private Date pEnddate;

    private String pExecuteinfo;

    private String pFilepath;

    private String pRemark;

    private Integer ctId;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
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

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle == null ? null : pTitle.trim();
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType == null ? null : pType.trim();
    }

    public Date getpSigningdate() {
        return pSigningdate;
    }

    public void setpSigningdate(Date pSigningdate) {
        this.pSigningdate = pSigningdate;
    }

    public Date getpExecdate() {
        return pExecdate;
    }

    public void setpExecdate(Date pExecdate) {
        this.pExecdate = pExecdate;
    }

    public Date getpEnddate() {
        return pEnddate;
    }

    public void setpEnddate(Date pEnddate) {
        this.pEnddate = pEnddate;
    }

    public String getpExecuteinfo() {
        return pExecuteinfo;
    }

    public void setpExecuteinfo(String pExecuteinfo) {
        this.pExecuteinfo = pExecuteinfo == null ? null : pExecuteinfo.trim();
    }

    public String getpFilepath() {
        return pFilepath;
    }

    public void setpFilepath(String pFilepath) {
        this.pFilepath = pFilepath == null ? null : pFilepath.trim();
    }

    public String getpRemark() {
        return pRemark;
    }

    public void setpRemark(String pRemark) {
        this.pRemark = pRemark == null ? null : pRemark.trim();
    }
}
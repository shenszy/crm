package com.zeyushen.springboot01.app.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PactPojo {
    private Integer pId;

    private String cName;

    private String sTName;

    private String ctName;

    private String pTitle;

    private String pType;

    private Date pSigningdate;

    private Date pExecdate;

    private Date pEnddate;

    private String pExecuteinfo;

    private String pFilepath;

    private String pRemark;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getsTName() {
        return sTName;
    }

    public void setsTName(String sTName) {
        this.sTName = sTName;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
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
        this.pExecuteinfo = pExecuteinfo;
    }

    public String getpFilepath() {
        return pFilepath;
    }

    public void setpFilepath(String pFilepath) {
        this.pFilepath = pFilepath;
    }

    public String getpRemark() {
        return pRemark;
    }

    public void setpRemark(String pRemark) {
        this.pRemark = pRemark;
    }
}

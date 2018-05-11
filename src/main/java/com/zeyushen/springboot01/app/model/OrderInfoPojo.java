package com.zeyushen.springboot01.app.model;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class OrderInfoPojo {
    private Integer oId;

    private Integer sId;

    private String gId;

    private Integer cId;

    private Integer oGnum;

    private Float oMoney;

    private Float oGprofit;

    private Date oAddtime;

    private String oRemark;

    private Date oExecutetime;

    private Integer pId;

    private String oState;

    private Float sellPrice;

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Date getoExecutetime() {
        return oExecutetime;
    }

    public void setoExecutetime(Date oExecutetime) {
        this.oExecutetime = oExecutetime;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getoState() {
        return oState;
    }

    public void setoState(String oState) {
        this.oState = oState;
    }

    public Integer getApprovalSid() {
        return approvalSid;
    }

    public void setApprovalSid(Integer approvalSid) {
        this.approvalSid = approvalSid;
    }

    private Integer approvalSid;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId == null ? null : gId.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getoGnum() {
        return oGnum;
    }

    public void setoGnum(Integer oGnum) {
        this.oGnum = oGnum;
    }

    public Float getoMoney() {
        return oMoney;
    }

    public void setoMoney(Float oMoney) {
        this.oMoney = oMoney;
    }

    public Float getoGprofit() {
        return oGprofit;
    }

    public void setoGprofit(Float oGprofit) {
        this.oGprofit = oGprofit;
    }

    public Date getoAddtime() {
        return oAddtime;
    }

    public void setoAddtime(Date oAddtime) {
        this.oAddtime = oAddtime;
    }

    public String getoRemark() {
        return oRemark;
    }

    public void setoRemark(String oRemark) {
        this.oRemark = oRemark == null ? null : oRemark.trim();
    }
}
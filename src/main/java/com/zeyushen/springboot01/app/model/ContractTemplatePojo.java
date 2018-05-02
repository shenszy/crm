package com.zeyushen.springboot01.app.model;

import org.springframework.stereotype.Component;

@Component
public class ContractTemplatePojo {
    private Integer ctId;

    private String ctName;

    private String ctFile;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName == null ? null : ctName.trim();
    }

    public String getCtFile() {
        return ctFile;
    }

    public void setCtFile(String ctFile) {
        this.ctFile = ctFile == null ? null : ctFile.trim();
    }
}
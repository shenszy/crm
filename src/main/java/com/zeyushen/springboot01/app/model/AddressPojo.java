package com.zeyushen.springboot01.app.model;

import org.springframework.stereotype.Component;

@Component
public class AddressPojo {

    private String currentID;

    private String address;

    private String parentID;


    public String getCurrentID() {
        return currentID;
    }

    public void setCurrentID(String currentID) {
        this.currentID = currentID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }
}

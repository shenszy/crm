package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.AddressPojoMapper;
import com.zeyushen.springboot01.app.model.AddressPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressServices")
public class AddressServices {
    @Autowired
    private AddressPojoMapper addressPojoMapper;

    public List<AddressPojo> getArea(String parentID){
        if(parentID==null||parentID.equals("")){
            return addressPojoMapper.getProvince();
        }else {
            return addressPojoMapper.getCityAndArea(parentID);
        }
    }

}

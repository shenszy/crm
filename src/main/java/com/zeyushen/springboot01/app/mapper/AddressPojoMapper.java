package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.AddressPojo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressPojoMapper {
    //查询省份
    public List<AddressPojo> getProvince();
    //查询市及区、县
    public List<AddressPojo> getCityAndArea(String parentID);


}

package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.CustomerInfoPojoMapper;
import com.zeyushen.springboot01.app.model.CustomerInfoPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerServices")
public class CustomerServices {
    @Autowired
    private CustomerInfoPojoMapper customerInfoPojoMapper;

    public List<CustomerInfoPojo> getAllCustomer(){return customerInfoPojoMapper.getAllCustomer();}
}

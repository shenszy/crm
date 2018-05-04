package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.CustomerInfoPojoMapper;
import com.zeyushen.springboot01.app.mapper.GoodsPojoMapper;
import com.zeyushen.springboot01.app.mapper.PactInfoPojoMapper;
import com.zeyushen.springboot01.app.model.CustomerInfoPojo;
import com.zeyushen.springboot01.app.model.GoodsPojo;
import com.zeyushen.springboot01.app.model.PactInfoPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderServices")
public class OrderServices {
    @Autowired
    GoodsPojoMapper goodsPojoMapper;
    @Autowired
    CustomerInfoPojoMapper customerInfoPojoMapper;
    @Autowired
    PactInfoPojoMapper pactInfoPojoMapper;

    public List<GoodsPojo> getProduct(){ return goodsPojoMapper.getProduct(); }

    public List<CustomerInfoPojo> getCustomer(){return customerInfoPojoMapper.getAllCustomer();}

    public List<PactInfoPojo> getPact(){return pactInfoPojoMapper.getAll();}
}

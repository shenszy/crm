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

    public int insertOneCustomer(CustomerInfoPojo customerInfoPojo){return customerInfoPojoMapper.insertOneCustomer(customerInfoPojo);}

    public int deleteById(Integer cId){return customerInfoPojoMapper.deleteById(cId);}

    public  List<CustomerInfoPojo> getCustomerByTerm(String cName,String spell,String cDegree,String cLevel){
        if(cDegree==null||cDegree.equals("")){
            cDegree=null;
        }
        if(cLevel==null||cLevel.equals("")){
            cLevel=null;
        }
        return customerInfoPojoMapper.getCustomerByTerm(cName,spell,cDegree,cLevel);
    }

    public CustomerInfoPojo getOneCustomer(Integer cId){return customerInfoPojoMapper.selectById(cId);}

    public int updateById(CustomerInfoPojo customerInfoPojo){return customerInfoPojoMapper.updateById(customerInfoPojo);}

}

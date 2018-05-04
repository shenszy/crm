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

    public boolean deleteById(Integer cId){return customerInfoPojoMapper.deleteById(cId)==1;}

    public  List<CustomerInfoPojo> getCustomerByTerm(String cName,String spell,String cDegree,String cLevel){
        if(cDegree==null||cDegree.isEmpty()){
            cDegree=null;
        }
        if(cLevel==null||cLevel.isEmpty()){
            cLevel=null;
        }
        if(cName==null||cName.isEmpty()||spell==null||spell.isEmpty()){
            cName="";
            spell="";
        }
        return customerInfoPojoMapper.getCustomerByTerm(cName,spell,cDegree,cLevel);
    }

    public CustomerInfoPojo getOneCustomer(Integer cId){return customerInfoPojoMapper.selectById(cId);}

    public int updateById(CustomerInfoPojo customerInfoPojo){return customerInfoPojoMapper.updateById(customerInfoPojo);}

}

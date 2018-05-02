package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.CustomerInfoPojo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerInfoPojoMapper {
//    int deleteByPrimaryKey(Integer cId);
//
//    int insert(CustomerInfoPojo record);
//
//    int insertSelective(CustomerInfoPojo record);
//
//    CustomerInfoPojo selectByPrimaryKey(Integer cId);
//
//    int updateByPrimaryKeySelective(CustomerInfoPojo record);
//
//    int updateByPrimaryKey(CustomerInfoPojo record);

    public List<CustomerInfoPojo> getAllCustomer();
}
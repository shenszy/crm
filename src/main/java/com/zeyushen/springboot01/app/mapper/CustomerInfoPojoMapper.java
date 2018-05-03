package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.CustomerInfoPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerInfoPojoMapper {
    int deleteById(Integer cId);

//    int insert(CustomerInfoPojo record);
//
    int insertOneCustomer(CustomerInfoPojo record);
//
//    CustomerInfoPojo selectByPrimaryKey(Integer cId);
//
//    int updateByPrimaryKeySelective(CustomerInfoPojo record);
//
//    int updateByPrimaryKey(CustomerInfoPojo record);

    public List<CustomerInfoPojo> getAllCustomer();

    public List<CustomerInfoPojo> getCustomerByTerm(@Param("cName") String cName,
                                                    @Param("spell") String spell,
                                                    @Param("cDegree") String cDegree,
                                                    @Param("cLevel") String cLevel);
}
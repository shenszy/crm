package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.OrderInfoPojo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderInfoPojoMapper {
    int deleteByPrimaryKey(Integer oId);

    int insert(OrderInfoPojo record);

    OrderInfoPojo selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(OrderInfoPojo record);

    int updateByPrimaryKey(OrderInfoPojo record);

    int insertSelective(OrderInfoPojo record);

    List<OrderInfoPojo> getMyOrder(Integer sId);
}
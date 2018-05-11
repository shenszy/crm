package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.OrderInfoPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderInfoPojoMapper {
    int deleteByPrimaryKey(Integer oId);

    int insert(OrderInfoPojo record);

    OrderInfoPojo selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(OrderInfoPojo record);

    int updateByPrimaryKey(OrderInfoPojo record);

    int insertSelective(OrderInfoPojo record);

    List<OrderInfoPojo> getMyOrder(@Param("uName") String uName, @Param("oId")String oId,@Param("oState") String oState);

    int updateOfState(OrderInfoPojo orderInfoPojo);

    List<OrderInfoPojo> getMyCheckOrder(@Param("uName") String uName, @Param("oId")String oId,@Param("oState") String oState);

    List<Map<String,Object>> getAllStaffSale();

    List<Map<String,Object>> getAllSaleByStaff(Integer id);
}
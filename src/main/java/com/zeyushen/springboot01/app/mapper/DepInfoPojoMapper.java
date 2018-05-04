package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.DepInfoPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepInfoPojoMapper {
//    int deleteByPrimaryKey(Integer dId);
//
//    int insert(DepInfoPojo record);
//
//    int insertSelective(DepInfoPojo record);
//
    DepInfoPojo selectByPrimaryKey(Integer dId);
//
//    int updateByPrimaryKeySelective(DepInfoPojo record);
//
//    int updateByPrimaryKey(DepInfoPojo record);

    //增删改查
    int addOneDep(String dName);
//
    int deleteById(Integer dId);
//
//    int updateById(Integer dId,String dName);

    List<DepInfoPojo> getAll();
}
package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.PactInfoPojo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PactInfoPojoMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(PactInfoPojo record);

    int updateByPrimaryKey(PactInfoPojo record);

    List<PactInfoPojo> getAll();

    int insertSelective(PactInfoPojo record);

    PactInfoPojo selectById(Integer pId);

    int updateById(PactInfoPojo record);

}
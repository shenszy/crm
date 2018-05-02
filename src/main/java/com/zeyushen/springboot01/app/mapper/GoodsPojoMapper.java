package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.GoodsPojo;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsPojoMapper {
    int deleteByPrimaryKey(String gId);

    int insert(GoodsPojo record);

    int insertSelective(GoodsPojo record);

    GoodsPojo selectByPrimaryKey(String gId);

    int updateByPrimaryKeySelective(GoodsPojo record);

    int updateByPrimaryKey(GoodsPojo record);
}
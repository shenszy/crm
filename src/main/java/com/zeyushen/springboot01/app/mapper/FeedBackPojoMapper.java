package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.FeedBackPojo;

public interface FeedBackPojoMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(FeedBackPojo record);

    int insertSelective(FeedBackPojo record);

    FeedBackPojo selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(FeedBackPojo record);

    int updateByPrimaryKey(FeedBackPojo record);
}
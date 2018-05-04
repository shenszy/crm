package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.GoodsPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsPojoMapper {
    int deleteByPrimaryKey(String gId);

    int insert(GoodsPojo record);

    int insertSelective(GoodsPojo record);

    GoodsPojo selectByPrimaryKey(String gId);

    int updateByPrimaryKeySelective(GoodsPojo record);

    int updateByPrimaryKey(GoodsPojo record);

    List<GoodsPojo> getGoodeByTerm(@Param("gName") String gName,@Param("spell") String spell,@Param("gAuthor") String gAuthor);

    List<String> getAuthor();
}
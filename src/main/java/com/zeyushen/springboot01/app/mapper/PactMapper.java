package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.PactPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PactMapper {
    List<PactPojo> getPactByTerm(@Param("pTitle") String pTitle,@Param("spell") String spell,@Param("execStatus") String execStatus);
}

package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.ContractTemplatePojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractTemplatePojoMapper {
    int insert(ContractTemplatePojo record);

    int updateByPrimaryKey(ContractTemplatePojo record);

    List<ContractTemplatePojo> getTemplateByTerm(@Param("ctName") String ctName,@Param("spell") String spell);

    int insertSelective(ContractTemplatePojo record);

    int deleteById(Integer ctId);

    ContractTemplatePojo selectById(Integer ctId);

    int updateById(ContractTemplatePojo record);
}
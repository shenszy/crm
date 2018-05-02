package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.ContractTemplatePojo;

public interface ContractTemplatePojoMapper {
    int deleteByPrimaryKey(Integer ctId);

    int insert(ContractTemplatePojo record);

    int insertSelective(ContractTemplatePojo record);

    ContractTemplatePojo selectByPrimaryKey(Integer ctId);

    int updateByPrimaryKeySelective(ContractTemplatePojo record);

    int updateByPrimaryKey(ContractTemplatePojo record);
}